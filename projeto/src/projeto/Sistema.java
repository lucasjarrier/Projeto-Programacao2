package projeto;

import java.util.ArrayList;
import java.util.Collections;

import item.EstadoItem;

public class Sistema {

	private ArrayList<Usuario> usuarios;
	private ArrayList<Item> todosItens;

	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
		this.todosItens = new ArrayList<Item>();
	}

	public Usuario getUsuario(int usuario) {
		return this.usuarios.get(usuario - 1);
	}
	
  public String getInfoUsuario(String nome, String telefone, String atributo) {
		Validador.validaInfoUsuario(nome, telefone, atributo);

		String retorno = "";
		for (Usuario usuario : this.usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getTelefone().equals(telefone)) {
				if (atributo.toLowerCase().equals("nome")) {
					retorno += nome;
				} else if (atributo.toLowerCase().equals("telefone")) {
					retorno += telefone;
				} else if (atributo.toLowerCase().equals("email")) {
					retorno += usuario.getEmail();
				}
			}
		}

		return retorno;
	}

	public void cadastraUsuario(String nome, String email, String telefone) {
		Validador.validaUsuario(nome, email, telefone);

		Usuario novoUsuario = new Usuario(nome, email, telefone);
		if (usuarios.contains(novoUsuario)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		} else {
			this.usuarios.add(novoUsuario);
		}
	}

	public String exibeUsuario(int usuario) {

		return this.getUsuario(usuario).toString();
	}

	public void atualizarUsuario(String nome, String email, String telefone, String atributo, String valor) {
		Validador.validaAtualizar(nome, telefone, valor, atributo);

		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getTelefone().equals(telefone)) {
				if (atributo.toLowerCase().equals("nome")) {
					usuario.setNome(valor);
				} else if (atributo.toLowerCase().equals("email")) {
					usuario.setEmail(valor);
				} else if (atributo.toLowerCase().equals("telefone")) {
					usuario.setTelefone(valor);
				}
			}
		}
	}


	public void removerUsuario(String nome, String telefone) throws Exception {
		Validador.validaRemover(nome, telefone);
		
			for (Usuario usuario : usuarios) {
				if (usuario.getNome().equals(nome) && usuario.getTelefone().equals(telefone)) {
					this.usuarios.remove(usuario);
				}
			}
	}

	private Usuario getUsuario(String nome, String telefone) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getNumero().equals(telefone)) {
				return usuario;
			}
		}
		throw new IllegalArgumentException("Usuario invalido");
		
	}
	public void cadastraFilme(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int ano) throws Exception {
		getUsuario(nomeUsuario, telefone).adicionaFilme(nomeItem, preco, duracao, classificacao, genero, ano);
	}
	
	
	public void cadastraSerie(String nomeUsuario, String telefone, String nomeItem, double preco, String descricao, int duracao,
			String genero, String classificacao, int temporada) throws Exception {
		getUsuario(nomeUsuario, telefone).adicionaSerie(nomeItem, preco, duracao, classificacao, descricao, genero, temporada);	
	}
	
	public void cadastraShow(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao, int faixas,
			String artista, String genero, String classificacao) throws Exception {
		getUsuario(nomeUsuario, telefone).adicionaShow(nomeItem, preco, duracao, classificacao, artista, faixas);
	}

	public void cadastraEletronico(String nomeUsuario, String telefone, String nomeItem, 
			double preco, String plataforma) throws Exception {
		getUsuario(nomeUsuario, telefone).adicionaEletronico(nomeItem, preco, plataforma);
	}
	
	public void cadastraJogoTabuleiro(String nomeUsuario, String telefone, String nomeItem, double preco) throws Exception {
		getUsuario(nomeUsuario, telefone).adicionaTabuleiro(nomeItem, preco);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		getUsuario(nome, telefone)
	}
	public String exibeItens(int usuario) {
		return this.getUsuario(usuario).exibirItens();
	}

	public void atualizaItem(int usuario, int item, EstadoItem estado) {

		if (usuario <= 0) {
			throw new IllegalArgumentException("Erro ao atualizar item: Usuario inv�lido");
		}
		if (usuario > usuarios.size()) {
			throw new IllegalArgumentException("Erro ao atualizar item: Usuario n�o cadastrado");
		}
		if (item <= 0) {
			throw new IllegalArgumentException("Erro ao atualizar item: Item inv�lido");
		}
		if (item > usuarios.get(usuario).getItens().size()) {
			throw new IllegalArgumentException("Erro ao atualizar item: Item n�o cadastrado");
		}

		/*
		 * FALTA IMPLEMENTAR ...
		 */
	}

	public void deletaItem(int usuario, int item) {

		if (usuario <= 0) {
			throw new IllegalArgumentException("Erro ao deletar item: Usuario inv�lido");
		}
		if (usuario > usuarios.size()) {
			throw new IllegalArgumentException("Erro ao deletar item: Usuario n�o cadastrado");
		}
		if (item <= 0) {
			throw new IllegalArgumentException("Erro ao deletar item: Item inv�lido");
		}
		if (item > usuarios.get(usuario).getItens().size()) {
			throw new IllegalArgumentException("Erro ao deletar item: Item n�o cadastrado");
		}
		
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
			if (usuarios.get(i).getNumero().equals(numeroUsuario)) {
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
