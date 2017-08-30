package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import comparators.ItemNomeComparator;
import comparators.ItemNumeroDeEmprestimosComparator;
import comparators.ItemValorComparator;
import comparators.MelhoresUsuariosReputacaoComparator;
import comparators.PioresUsuariosReputacaoComparator;
import item.EstadoItem;
import item.Item;
import usuario.Usuario;
import usuario.UsuarioID;
import utils.Validador;

public class Sistema {

	private Map<UsuarioID, Usuario> usuarios;
	private EmprestimoController sistemaEmprestimo;

	public Sistema() {
		this.usuarios = new HashMap<UsuarioID, Usuario>();
		this.sistemaEmprestimo = new EmprestimoController();
	}

	/**
	 * Cadastra um novo usuario no sistema.
	 * 
	 * @param nome
	 * @param telefone
	 * @param email
	 */

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Validador.validaUsuario(nome, email, telefone);

		if (this.usuarios.containsKey(new UsuarioID(nome, telefone))) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

		this.usuarios.put((new UsuarioID(nome, telefone)), new Usuario(nome, telefone, email));
	}

	/**
	 * Remova usuario ja cadastrado.
	 * 
	 * @param nome
	 * @param telefone
	 */
	public void removerUsuario(String nome, String telefone) {
		Validador.validaRemover(nome, telefone);

		UsuarioID usuarioID = new UsuarioID(nome, telefone);
		if (usuarios.containsKey(usuarioID)) {
			this.usuarios.remove(usuarioID);
		} else {
			throw new IllegalArgumentException("Usuario invalido");
		}

	}

	/**
	 * Recebe um atributo e atualiza o valor do atributo no Usuario ja cadastrado.
	 * 
	 * @param nome
	 * @param telefone
	 * @param atributo
	 * @param valor
	 */
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

	/**
	 * Recebe um atributo e depedendo do mesmo, retorna o valor atribuido a ele.
	 * 
	 * @param nome
	 * @param telefone
	 * @param atributo
	 * @return valor equivalente ao atributo.
	 */

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		UsuarioID usuario = new UsuarioID(nome, telefone);

		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return usuarios.get(usuario).getInfoUsuario(atributo);
	}

	private Usuario getUsuario(String nome, String telefone) {
		UsuarioID usuario = new UsuarioID(nome, telefone);
		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return this.usuarios.get(usuario);
	}

	/**
	 * 
	 * Esse metodo eh responsavel por cadastrar um filme.
	 * 
	 * @param nomeUsuario
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param preco
	 *            Eh o preco do item.
	 * @param duracao
	 *            Eh a duracao do filme.
	 * @param genero
	 *            Eh o genero do filme.
	 * @param classificacao
	 *            Eh a classificacao etaria do filme.
	 * @param ano
	 *            Eh o ano de lancamento do filme.
	 * @throws Exception
	 *             Lanca excecao caso o preco seja menor ou igual a zero.
	 */

	public void cadastraFilme(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int ano) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}

		getUsuario(nomeUsuario, telefone).adicionaFilme(nomeItem, preco, duracao, classificacao, genero, ano);
	}

	/**
	 * 
	 * Esse metodo eh responsavel por cadastrar uma serie.
	 * 
	 * @param nomeUsuario
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param preco
	 *            Eh o preco do item.
	 * @param descricao
	 *            Eh a descricao da serie.
	 * @param duracao
	 *            Eh a duracao da serie.
	 * @param genero
	 *            Eh o genero da serie.
	 * @param classificacao
	 *            Eh a classificacao etaria da serie.
	 * @param temporada
	 *            Eh a temporada da serie.
	 * @throws Exception
	 *             Lanca excecao caso o preco seja menor ou igual a zero.
	 */

	public void cadastraSerie(String nomeUsuario, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String genero, String classificacao, int temporada) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaSerie(nomeItem, preco, duracao, classificacao, descricao, genero,
				temporada);
	}

	/**
	 * 
	 * Esse metodo eh responsavel por cadastrar um show.
	 * 
	 * @param nomeUsuario
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param preco
	 *            Eh o preco do item.
	 * @param duracao
	 *            Eh a duracao da serie.
	 * @param faixas
	 *            Eh a quantidade de faixas do show.
	 * @param artista
	 *            Eh o nome do artista.
	 * @param classificacao
	 *            Eh a classificacao etaria do show.
	 * @throws Exception
	 *             Lanca excecao caso o preco seja menor ou igual a zero.
	 */

	public void cadastraShow(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			int faixas, String artista, String classificacao) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaShow(nomeItem, preco, duracao, classificacao, artista, faixas);
	}

	/**
	 * 
	 * Esse metodo eh responsavel por cadastrar jogos eletronicos.
	 * 
	 * @param nomeUsuario
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param preco
	 *            Eh o preco do item.
	 * @param plataforma
	 *            Eh a plataforma do jogo.
	 * @throws Exception
	 *             Lanca excecao caso o preco seja menor ou igual a zero.
	 */

	public void cadastraEletronico(String nomeUsuario, String telefone, String nomeItem, double preco,
			String plataforma) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaEletronico(nomeItem, preco, plataforma);
	}

	/**
	 * 
	 * Esse metodo eh responsavel por cadastrar um jogo de tabuleiro.
	 * 
	 * @param nomeUsuario
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param preco
	 *            Eh o preco do item.
	 * @throws Exception
	 *             Lanca excecao caso o preco seja menor ou igual a zero.
	 */

	public void cadastraJogoTabuleiro(String nomeUsuario, String telefone, String nomeItem, double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaTabuleiro(nomeItem, preco);
	}

	/**
	 * 
	 * Esse metodo eh responsavel por adicionar um episodio numa serie.
	 * 
	 * @param nomeUsuario
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeBlurayTemporada
	 *            Eh o nome do bluray no qual quer se adicionar o episodio.
	 * @param duracao
	 *            Eh a duracao do episodio.
	 * @throws Exception
	 */

	public void adicionarBluRay(String nomeUsuario, String telefone, String nomeBlurayTemporada, int duracao) {
		getUsuario(nomeUsuario, telefone).adicionaBluRay(nomeBlurayTemporada, duracao);
	}

	/**
	 * 
	 * Esse metodo adiciona uma peca perdida do jogo de tabuleiro.
	 * 
	 * @param nome
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param nomePeca
	 *            Eh o nome da peca perdida.
	 * @throws Exception
	 */

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		getUsuario(nome, telefone).adicionaPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * 
	 * Esse metodo retorna informacoes sobre os itens de acordo com o atributo
	 * escolhido.
	 * 
	 * @param nomeUsuario
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param atributo
	 *            Eh o atributo que se quer ter a informacao.
	 * @return Retorna o atributo escolhido.
	 * @throws Exception
	 *             Lanca excecao caso o usuario nao exista.
	 */

	public String getInfoItem(String nomeUsuario, String telefone, String nomeItem, String atributo) {
		UsuarioID usuario = new UsuarioID(nomeUsuario, telefone);
		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return usuarios.get(usuario).getInfoItem(nomeItem, atributo);

	}

	/**
	 * Esse metodo atualiza atributos do item.
	 * 
	 * @param nomeUsuario
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param atributo
	 *            Eh o atributo que se quer atualizar.
	 * @param valor
	 *            Eh o que vai ser substituido.
	 * @throws Exception
	 *             Lanca excecao caso o usuario nao exista.
	 */

	public void atualizaItem(String nomeUsuario, String telefone, String nomeItem, String atributo, String valor) {
		Usuario usuario = getUsuario(nomeUsuario, telefone);
		usuario.atualizarItem(nomeItem, atributo, valor);
	}

	/**
	 * 
	 * Esse metodo remove algum item do usuario.
	 * 
	 * @param nomeUsuario
	 *            Eh o nome do usuario.
	 * @param telefone
	 *            Eh o numero do telefone.
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @throws Exception
	 *             Lanca excecao caso o usuario nao exista.
	 */

	public void removerItem(String nomeUsuario, String telefone, String nomeItem) {
		Usuario usuario = getUsuario(nomeUsuario, telefone);
		usuario.removeItem(nomeItem);
	}

	/**
	 * 
	 * @return Retorna em String todos os Itens cadastrado em ordem alfabetica
	 */

	public String listarItensOrdenadosPorNome() {
		ArrayList<Item> itensOrdenados = new ArrayList<Item>();
		String listagem = "";

		for (Usuario usuario : this.usuarios.values()) {
			itensOrdenados.addAll(usuario.getItens());
		}
		Collections.sort(itensOrdenados, new ItemNomeComparator());

		for (Item item : itensOrdenados) {
			listagem += item.toString() + "|";
		}
		return listagem;
	}

	/**
	 * 
	 * @return Retorna em String todos os Itens cadastrado em ordem de maior Valor.
	 */

	public String listarItensOrdenadosPorValor() {
		ArrayList<Item> itensOrdenados = new ArrayList<Item>();
		String listagem = "";

		for (Usuario usuario : this.usuarios.values()) {

			itensOrdenados.addAll(usuario.getItens());
		}

		Collections.sort(itensOrdenados, new ItemValorComparator());

		for (Item item : itensOrdenados) {
			listagem += item.toString() + "|";
		}
		return listagem;
	}

	/**
	 * @param Item
	 *            Parametro que recebe o nome de um Item.
	 * @param Usuario
	 *            Parametro que recebe o nome de um Usuario que Possui esse Item.
	 * @param Usuario
	 *            Parametro que recebe o numero de um USuario que Possui esse Item.
	 * @return Retorna em String um determinado Item de forma detalhada.
	 */

	public String pesquisarDetalhesItem(String nome, String telefone, String item) {
		UsuarioID usuario = new UsuarioID(nome, telefone);
		if (!this.usuarios.containsKey(usuario)) {
			throw new NullPointerException("Usuario invalido");
		}
		return this.usuarios.get(usuario).getItem(item).toString();
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeReceptor, String telefoneReceptor,
			String nomeItem, String dataEmprestimo, int periodo) {
		UsuarioID usuarioDonoID = new UsuarioID(nomeDono, telefoneDono);
		UsuarioID usuarioReceptorID = new UsuarioID(nomeReceptor, telefoneReceptor);
		if (!this.usuarios.containsKey(usuarioDonoID) || !this.usuarios.containsKey(usuarioReceptorID)) {
			throw new NullPointerException("Usuario invalido");
		}

		if (usuarios.get(usuarioReceptorID).getReputacao() < 0) {
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		}

		if (periodo > usuarios.get(usuarioReceptorID).getCartaoReputacao().getPeriodoMaximo()) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}

		Usuario dono = this.usuarios.get(usuarioDonoID);
		Usuario receptor = this.usuarios.get(usuarioReceptorID);
		Item itemEmprestimo = dono.getItem(nomeItem);

		if (itemEmprestimo.getEstado().equals(EstadoItem.INDISPONIVEL)) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}

		this.sistemaEmprestimo.registrarEmprestimo(dono, receptor, itemEmprestimo, dataEmprestimo, periodo);

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

		this.sistemaEmprestimo.devolverItem(dono, receptor, itemEmprestimo, dataEmprestimo, dataDevolucao);

	}

	/**
	 * Metodo do programa que ordena os 10 Piores Usuarios
	 * 
	 * @return Retorna um texto no formato de String em ordem de Piores Usuarios
	 */

	public String listarTop10PioresUsuarios() {
		ArrayList<Usuario> top10Usuarios = new ArrayList<Usuario>(this.usuarios.values());
		String listagem = "";

		Collections.sort(top10Usuarios, new PioresUsuariosReputacaoComparator());

		int cont = 1;
		for (Usuario usuario : top10Usuarios) {
			if (cont > 10) {
				return listagem;
			}
			String reputacao = String.format("%.2f", usuario.getReputacao());
			listagem += (cont + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|");
			cont++;
		}
		return listagem;
	}

	/**
	 * 
	 * @return Retorna uma String todos os usuarios com reputação negativa.
	 */

	public String listarCaloteiros() {
		String listarCaloteiros = "";

		for (Usuario usuario : this.usuarios.values()) {
			if (usuario.getReputacao() < 0) {
				listarCaloteiros += usuario.toString() + "|";
			}
		}
		return "Lista de usuarios com reputacao negativa: " + listarCaloteiros;
	}

	/**
	 * Metodo do programa que ordena os 10 Melhores Usuarios
	 * 
	 * @return Retorna um texto no formato de String em ordem de Melhores Usuarios
	 */

	public String listarTop10MelhoresUsuarios() {
		ArrayList<Usuario> top10Usuarios = new ArrayList<Usuario>(this.usuarios.values());
		String listagem = "";

		Collections.sort(top10Usuarios, new MelhoresUsuariosReputacaoComparator());

		int cont = 1;
		for (Usuario usuario : top10Usuarios) {
			if (cont > 10) {
				return listagem;
			}
			String reputacao = String.format("%.2f", usuario.getReputacao());
			listagem += (cont + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|");
			cont++;
		}
		return listagem;
	}

	public String listarItensNaoEmprestados() {
		ArrayList<Item> itensNaoEmprestados = new ArrayList<Item>();

		for (Usuario usuario : this.usuarios.values()) {
			itensNaoEmprestados.addAll(usuario.listarItensNaoEmprestados());
		}

		Collections.sort(itensNaoEmprestados, new ItemNomeComparator());
		String listagem = "";

		for (Item item : itensNaoEmprestados) {
			listagem += item.toString() + "|";
		}

		return listagem;

	}

	public String listarTop10Itens() {
		ArrayList<Item> itens = new ArrayList<Item>();
		String top10 = "";

		for (Usuario usuario : this.usuarios.values()) {
			itens.addAll(usuario.getItensComEmprestimos());
		}

		Collections.sort(itens, new ItemNumeroDeEmprestimosComparator());

		int cont = 1;
		for (Item item : itens) {
			if (cont > 10) {
				return top10;
			}
			top10 += cont + ") " + item.getNumeroDeEmprestimos() + " emprestimos - " + item.toString() + "|";
			cont++;
		}

		return top10;

	}

	public void validaUsuario(String nome, String telefone) {
		if (!this.usuarios.containsKey(new UsuarioID(nome, telefone))) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	public String listarEmprestimosEmprestando(String nome, String telefone) {
		this.validaUsuario(nome, telefone);
		return this.sistemaEmprestimo.listarEmprestimosEmprestando(nome, telefone);
	}

	public String listarEmprestimosPegandoEmprestado(String nome, String telefone) {
		this.validaUsuario(nome, telefone);
		return this.sistemaEmprestimo.listarEmprestimosPegandoEmprestado(nome, telefone);
	}

	public String listaEmprestimosItem(String nomeItem) {
		return this.sistemaEmprestimo.listaEmprestimosItem(nomeItem);

	}

	public String listarItensEmprestados() {
		return this.sistemaEmprestimo.listarItensEmprestados();

	}

}