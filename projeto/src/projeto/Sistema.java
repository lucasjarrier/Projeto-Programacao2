package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import item.EstadoItem;
import item.Item;

public class Sistema {

	private HashMap<NomeETelefone, Usuario> usuarios;

	public Sistema() {
		this.usuarios = new HashMap<NomeETelefone, Usuario>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Validador.validaUsuario(nome, email, telefone);

		if (this.usuarios.containsKey(new NomeETelefone(nome, telefone))) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

		this.usuarios.put((new NomeETelefone(nome, telefone)), new Usuario(nome, telefone, email));
	}

	public void removerUsuario(String nome, String telefone) {
		Validador.validaRemover(nome, telefone);

		NomeETelefone NomeETelefone = new NomeETelefone(nome, telefone);
		if (usuarios.containsKey(NomeETelefone)) {
			this.usuarios.remove(NomeETelefone);
		} else {
			throw new IllegalArgumentException("Usuario invalido");
		}

	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		Validador.validaAtualizar(nome, telefone, valor, atributo);

		NomeETelefone usuario = new NomeETelefone(nome, telefone);

		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}

		if (atributo.equals("Nome")) {
			this.usuarios.put(new NomeETelefone(valor, telefone),
					new Usuario(valor, telefone, this.usuarios.get(usuario).getEmail()));
			usuarios.remove(usuario);
		} else if (atributo.equals("Telefone")) {
			this.usuarios.put(new NomeETelefone(nome, valor),
					new Usuario(nome, valor, this.usuarios.get(usuario).getEmail()));
			usuarios.remove(usuario);
		} else if (atributo.equals("Email")) {
			this.usuarios.get(usuario).setEmail(valor);
		}
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		NomeETelefone usuario = new NomeETelefone(nome, telefone);
		String info = "";

		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}

		if (atributo.equals("Nome")) {
			info = usuarios.get(usuario).getNome();
		} else if (atributo.equals("Telefone")) {
			info = usuarios.get(usuario).getEmail();
		} else if (atributo.equals("Email")) {
			info = usuarios.get(usuario).getEmail();
		}

		return info;

	}

	private Usuario getUsuario(String nome, String telefone) throws Exception {
		NomeETelefone usuario = new NomeETelefone(nome, telefone);
		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return usuarios.get(usuario);
	}
		
	public void cadastraFilme(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int ano) throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaFilme(nomeItem, preco, duracao, classificacao, genero, ano);
	}
	
	
	public void cadastraSerie(String nomeUsuario, String telefone, String nomeItem, double preco, String descricao, int duracao,
			String genero, String classificacao, int temporada) throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaSerie(nomeItem, preco, duracao, classificacao, descricao, genero, temporada);	
	}
	
	public void cadastraShow(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao, int faixas,
			String artista, String classificacao) throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaShow(nomeItem, preco, duracao, classificacao, artista, faixas);
	}

	public void cadastraEletronico(String nomeUsuario, String telefone, String nomeItem, 
			double preco, String plataforma) throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaEletronico(nomeItem, preco, plataforma);
	}
	
	public void cadastraJogoTabuleiro(String nomeUsuario, String telefone, String nomeItem, double preco) throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaTabuleiro(nomeItem, preco);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		getUsuario(nome, telefone).adicionaPecaPerdida(nomeItem, nomePeca);
	}
	
	public String getInfoItem(String nomeUsuario, String telefone, String nomeItem, String atributo) throws Exception {
		NomeETelefone usuario = new NomeETelefone(nomeUsuario, telefone);
		String info = "";
		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (atributo.equals("Preco")) {
			info += usuarios.get(usuario).getItem(nomeItem).getValor();
		} else if (atributo.equals("Nome")) {
			info += usuarios.get(usuario).getItem(nomeItem).getNome();
		}
		return info;
	}

	public void atualizaItem(String nomeUsuario, String telefone, String nomeItem, String atributo, String valor) throws Exception {
		Usuario usuario = getUsuario(nomeUsuario, telefone);
		if (atributo.toLowerCase().equals("preco")) {
			usuario.getItem(nomeItem).setValor(Double.parseDouble(valor));
		} else if (atributo.toLowerCase().equals("nome")) {
			usuario.getItem(nomeItem).setNome(valor);
		}
	}

	public void removerItem(String nomeUsuario, String telefone, String nomeItem) throws Exception {
		Usuario usuario = getUsuario(nomeUsuario, telefone);
		usuario.removeItem(nomeItem);
	}
	
  public String listarItensOrdenadosPorNome() {

		ArrayList<Item> novoArray = new ArrayList<Item>();
		for (int i = 0; i < usuarios.size(); i++) {
			for (int e = 0; e < usuarios.get(i).getItens().size(); e++) {
				novoArray.addAll(usuarios.get(i).getItens());
			}
		}
		String retorno = "";
		Collections.sort(novoArray, new NomeComparator());

		for (int i = 0; i < novoArray.size(); i++) {
			retorno += novoArray.get(i).toString() + " ";
		}
		return retorno;
	}

	/**
	 * 
	 * @return Retorna em String todos os Itens cadastrado em ordem de maior
	 *         Valor.
	 */

	public String listarItensOrdenadosPorValor() {

		ArrayList<Item> novoArray = new ArrayList<Item>();
		for (int i = 0; i < usuarios.size(); i++) {
			for (int e = 0; e < usuarios.get(i).getItens().size(); e++) {
				novoArray.addAll(usuarios.get(i).getItens());
			}
		}
		String retorno = "";
		Collections.sort(novoArray, new ValorComparator());

		for (int i = 0; i < novoArray.size(); i++) {
			retorno += novoArray.get(i).toString() + " ";
		}
		return retorno;
	}

	/**
	 * 
	 * @param nomeItem
	 *            Parametro que recebe o nome de um Item.
	 * @param nomeUsuario
	 *            Parametro que recebe o nome de um Usuario que Possui esse
	 *            Item.
	 * @param numeroUsuario
	 *            Parametro que recebe o numero de um USuario que Possui esse
	 *            Item.
	 * @return Retorna em String um determinado Item de forma detalhada.
	 */

	public String pesquisarDetalhesItem(String nomeItem, String nomeUsuario, String numeroUsuario) {

		boolean contemNome = false;
		boolean contemNumero = false;

		String retorno = "";

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome().equals(nomeUsuario)) {
				contemNome = true;
			}
			if (usuarios.get(i).getTelefone().equals(numeroUsuario)) {
				contemNumero = true;
			}
			if (contemNome == true && contemNumero == true) {
				for (int e = 0; e < usuarios.get(i).getItens().size(); e++) {
					if (usuarios.get(i).getItens().get(e).getNome().equals(nomeItem)) {
						retorno += usuarios.get(i).getItens().get(e).toString();
					}
				}
			}
		}
		return retorno;
	}
}
