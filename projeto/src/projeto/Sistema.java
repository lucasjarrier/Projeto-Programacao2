package projeto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import emprestimo.Emprestimo;
import emprestimo.EmprestimoID;
import item.EstadoItem;
import item.Item;
import usuario.Usuario;
import usuario.UsuarioID;

public class Sistema {

	private Map<UsuarioID, Usuario> usuarios;
	private Map<EmprestimoID, Emprestimo> emprestimos;

	public Sistema() {
		this.usuarios = new HashMap<UsuarioID, Usuario>();
		this.emprestimos = new HashMap<EmprestimoID, Emprestimo>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Validador.validaUsuario(nome, email, telefone);

		if (this.usuarios.containsKey(new UsuarioID(nome, telefone))) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

		this.usuarios.put((new UsuarioID(nome, telefone)), new Usuario(nome, telefone, email));
	}

	public void removerUsuario(String nome, String telefone) {
		Validador.validaRemover(nome, telefone);

		UsuarioID NomeETelefone = new UsuarioID(nome, telefone);
		if (usuarios.containsKey(NomeETelefone)) {
			this.usuarios.remove(NomeETelefone);
		} else {
			throw new IllegalArgumentException("Usuario invalido");
		}

	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		Validador.validaAtualizar(nome, telefone, valor, atributo);

		UsuarioID usuario = new UsuarioID(nome, telefone);

		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}

		if (atributo.equals("Nome")) {
			this.usuarios.put(new UsuarioID(valor, telefone),
					new Usuario(valor, telefone, this.usuarios.get(usuario).getEmail()));
			usuarios.remove(usuario);
		} else if (atributo.equals("Telefone")) {
			this.usuarios.put(new UsuarioID(nome, valor),
					new Usuario(nome, valor, this.usuarios.get(usuario).getEmail()));
			usuarios.remove(usuario);
		} else if (atributo.equals("Email")) {
			this.usuarios.get(usuario).setEmail(valor);
		}
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		UsuarioID usuario = new UsuarioID(nome, telefone);
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
		UsuarioID usuario = new UsuarioID(nome, telefone);
		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return this.usuarios.get(usuario);
	}

	public void cadastraFilme(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int ano) throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaFilme(nomeItem, preco, duracao, classificacao, genero, ano);
	}

	public void cadastraSerie(String nomeUsuario, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String genero, String classificacao, int temporada) throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaSerie(nomeItem, preco, duracao, classificacao, descricao, genero,
				temporada);
	}

	public void cadastraShow(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			int faixas, String artista, String classificacao) throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaShow(nomeItem, preco, duracao, classificacao, artista, faixas);
	}

	public void cadastraEletronico(String nomeUsuario, String telefone, String nomeItem, double preco,
			String plataforma) throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaEletronico(nomeItem, preco, plataforma);
	}

	public void cadastraJogoTabuleiro(String nomeUsuario, String telefone, String nomeItem, double preco)
			throws Exception {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaTabuleiro(nomeItem, preco);
	}

	public void adicionarBluRay(String nomeUsuario, String telefone, String nomeBlurayTemporada, int duracao)
			throws Exception {
		getUsuario(nomeUsuario, telefone).adicionaBluRay(nomeBlurayTemporada, duracao);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		getUsuario(nome, telefone).adicionaPecaPerdida(nomeItem, nomePeca);
	}

	public String getInfoItem(String nomeUsuario, String telefone, String nomeItem, String atributo) throws Exception {
		UsuarioID usuario = new UsuarioID(nomeUsuario, telefone);
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

	public void atualizaItem(String nomeUsuario, String telefone, String nomeItem, String atributo, String valor)
			throws Exception {
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

		ArrayList<Item> itensOrdenados = new ArrayList<Item>();
		Collection<Usuario> valor = usuarios.values();

		for (Usuario usuario : valor) {
			for (int i = 0; i < usuario.getItens().size(); i++) {
				itensOrdenados.add(usuario.getItens().get(i));
			}
		}

		Collections.sort(itensOrdenados, new NomeComparator());
		String retorno = "";

		for (Item item : itensOrdenados) {
			retorno += item.toString() + "|";
		}
		return retorno;
	}

	/**
	 * 
	 * @return Retorna em String todos os Itens cadastrado em ordem de maior
	 *         Valor.
	 */

	public String listarItensOrdenadosPorValor() {

		ArrayList<Item> itensOrdenados = new ArrayList<Item>();
		Collection<Usuario> valor = usuarios.values();

		for (Usuario usuario : valor) {
			for (int i = 0; i < usuario.getItens().size(); i++) {
				itensOrdenados.add(usuario.getItens().get(i));
			}
		}

		Collections.sort(itensOrdenados, new ValorComparator());
		String retorno = "";

		for (Item item : itensOrdenados) {
			retorno += item.toString() + "|";
		}
		return retorno;
	}

	/**
	 * @param Item
	 *            Parametro que recebe o nome de um Item.
	 * @param Usuario
	 *            Parametro que recebe o nome de um Usuario que Possui esse
	 *            Item.
	 * @param Usuario
	 *            Parametro que recebe o numero de um USuario que Possui esse
	 *            Item.
	 * @return Retorna em String um determinado Item de forma detalhada.
	 */

	public String pesquisarDetalhesItem(String nome, String telefone, String item) throws Exception {

		UsuarioID usuario = new UsuarioID(nome, telefone);

		if (!this.usuarios.containsKey(usuario)) {
			throw new NullPointerException("Usuario invalido");
		}

		return this.usuarios.get(usuario).getItem(item).toString();
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeReceptor, String telefoneReceptor,
			String nomeItem, String dataEmprestimo, int periodo) throws Exception {

		UsuarioID usuarioDonoID = new UsuarioID(nomeDono, telefoneDono);
		UsuarioID usuarioReceptorID = new UsuarioID(nomeReceptor, telefoneReceptor);

		if (!this.usuarios.containsKey(usuarioDonoID) || !this.usuarios.containsKey(usuarioReceptorID)) {
			throw new NullPointerException("Usuario invalido");
		}

		Usuario dono = this.usuarios.get(usuarioDonoID);
		Usuario receptor = this.usuarios.get(usuarioReceptorID);
		Item itemEmprestimo = dono.getItem(nomeItem);

		if (itemEmprestimo.getEstado().equals(EstadoItem.INDISPONIVEL)) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}

		EmprestimoID emprestimoID = new EmprestimoID(dono, receptor, itemEmprestimo);

		if (this.emprestimos.containsKey(emprestimoID)) {
			throw new IllegalArgumentException("Emprestimo ja existe");
		}

		Emprestimo emprestimo = new Emprestimo(dono, receptor, itemEmprestimo, periodo, dataEmprestimo);
		emprestimos.put(emprestimoID, emprestimo);
		dono.registraEmprestimo(emprestimo);
		receptor.registraEmprestimo(emprestimo);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeReceptor, String telefoneReceptor,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		UsuarioID usuarioDonoID = new UsuarioID(nomeDono, telefoneDono);
		UsuarioID usuarioReceptorID = new UsuarioID(nomeReceptor, telefoneReceptor);

		if (!this.usuarios.containsKey(usuarioDonoID) || !this.usuarios.containsKey(usuarioReceptorID)) {
			throw new NullPointerException("Usuario invalido");
		}

		Usuario dono = this.usuarios.get(usuarioDonoID);
		Usuario receptor = this.usuarios.get(usuarioReceptorID);
		Item itemEmprestimo = dono.getItem(nomeItem);

		EmprestimoID emprestimoID = new EmprestimoID(dono, receptor, itemEmprestimo);

		if (!this.emprestimos.containsKey(emprestimoID)) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}

		emprestimos.get(emprestimoID).devolveItem(dataEmprestimo, dataDevolucao);

	}

}