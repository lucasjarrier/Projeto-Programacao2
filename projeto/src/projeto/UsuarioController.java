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

/**
 * Representação de um Controller de Usuários, que controla e exerce
 * funcionalidades sobre os usuários.
 * 
 * @author Higor
 *
 */

public class UsuarioController {

	private Map<UsuarioID, Usuario> usuarios;
	private EmprestimoController emprestimoController;

	/**
	 * Constrói um Controller de Usuários.
	 * 
	 */

	public UsuarioController() {
		this.usuarios = new HashMap<UsuarioID, Usuario>();
		this.emprestimoController = new EmprestimoController();
	}

	/**
	 * Cadastra um novo usuario no sistema.
	 * 
	 * @param nome
	 *            nome do usuário
	 * @param telefone
	 *            telefone do usuário
	 * @param email
	 *            email eletrônico do usuário
	 */

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Validador.validaUsuario(nome, email, telefone);

		if (this.usuarios.containsKey(new UsuarioID(nome, telefone))) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

		this.usuarios.put((new UsuarioID(nome, telefone)), new Usuario(nome, telefone, email));
	}

	/**
	 * Remove usuario já cadastrado.
	 * 
	 * @param nome
	 *            nome do usuário
	 * @param telefone
	 *            telefone do usuário
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
	 * Recebe um atributo e atualiza o valor do atributo no Usuario já cadastrado.
	 * 
	 * @param nome
	 *            nome do usuário
	 * @param telefone
	 *            telefone do usuário
	 * @param atributo
	 *            atributo a ser atualizado
	 * @param valor
	 *            valor do novo atributo
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
	 *            nome do usuário
	 * @param telefone
	 *            telefone do usuário
	 * @param atributo
	 *            atributo a ser retornado
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
	 * Cadastra um filme no sistema.
	 * 
	 * @param nomeUsuario
	 *            nome do usuário
	 * @param telefone
	 *            numero telefônico do usuário
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param duracao
	 *            duração do filme
	 * @param genero
	 *            gênero do filme
	 * @param classificacao
	 *            classificação indicativa do filme
	 * @param ano
	 *            ano de lancamento do filme
	 * 
	 */

	public void cadastraFilme(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int ano) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}

		getUsuario(nomeUsuario, telefone).adicionaFilme(nomeItem, preco, duracao, classificacao, genero, ano);
	}

	/**
	 * Esse metodo eh responsavel por cadastrar uma serie.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param descricao
	 *            descrição da serie
	 * @param duracao
	 *            duração da serie
	 * @param genero
	 *            gênero da serie
	 * @param classificacao
	 *            classificação indicativa da serie
	 * @param temporada
	 *            temporada da serie
	 * 
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
	 * Cadastra um show no sistema.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuário
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param duracao
	 *            duração da serie
	 * @param faixas
	 *            quantidade de faixas do show
	 * @param artista
	 *            nome do artista
	 * @param classificacao
	 *            classificacao indicativa do show
	 * 
	 */

	public void cadastraShow(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			int faixas, String artista, String classificacao) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaShow(nomeItem, preco, duracao, classificacao, artista, faixas);
	}

	/**
	 * Cadastra um jogo eletrônico no sistema.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param plataforma
	 *            plataforma do jogo
	 * 
	 */

	public void cadastraEletronico(String nomeUsuario, String telefone, String nomeItem, double preco,
			String plataforma) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaEletronico(nomeItem, preco, plataforma);
	}

	/**
	 * Cadastra um jogo de tabuleiro no sistema.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuário
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * 
	 */

	public void cadastraJogoTabuleiro(String nomeUsuario, String telefone, String nomeItem, double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaTabuleiro(nomeItem, preco);
	}

	/**
	 * Adiciona um episódio a um BluRaySerie.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuário
	 * @param nomeBlurayTemporada
	 *            nome do bluray
	 * @param duracao
	 *            duracao do episodio a ser adicionado
	 * 
	 */

	public void adicionarBluRay(String nomeUsuario, String telefone, String nomeBlurayTemporada, int duracao) {
		getUsuario(nomeUsuario, telefone).adicionaBluRay(nomeBlurayTemporada, duracao);
	}

	/**
	 * Adiciona uma peça perdida a um jogo de tabuleiro.
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param nomePeca
	 *            nome da peça perdida
	 */

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		getUsuario(nome, telefone).adicionaPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Esse metodo retorna informações sobre o item de acordo com o atributo
	 * escolhido.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo que se quer ter a informacao
	 * @return atributo escolhido
	 * 
	 */

	public String getInfoItem(String nomeUsuario, String telefone, String nomeItem, String atributo) {
		UsuarioID usuario = new UsuarioID(nomeUsuario, telefone);
		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return usuarios.get(usuario).getInfoItem(nomeItem, atributo);

	}

	/**
	 * Esse metodo atualiza determinado atributo do item.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo que se quer atualizar
	 * @param valor
	 *            novo valor do atributo
	 * 
	 */

	public void atualizaItem(String nomeUsuario, String telefone, String nomeItem, String atributo, String valor) {
		Usuario usuario = getUsuario(nomeUsuario, telefone);
		usuario.atualizarItem(nomeItem, atributo, valor);
	}

	/**
	 * 
	 * Esse metodo remove um item do usuario.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuário
	 * @param nomeItem
	 *            nome do item a ser removido
	 * 
	 */

	public void removerItem(String nomeUsuario, String telefone, String nomeItem) {
		Usuario usuario = getUsuario(nomeUsuario, telefone);
		usuario.removeItem(nomeItem);
	}

	/**
	 * Lista os itens cadastrados de todos os usuários ordenados pelo nome.
	 * 
	 * @return listagem de todos itens ordenados pelo nome
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
	 * Lista os itens cadastrados de todos os usuários ordenados pelo valor.
	 * 
	 * @return listagem de todos os itens ordenados pelo valor
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
	 * Pesquisa detalhes de determinado item.
	 * 
	 * @param nome
	 *            nome do usuário
	 * @param telefone
	 *            telefone do usuário
	 * @param item
	 *            nome do item a retornar essas informações
	 * @return detalhes do item em String
	 */

	public String pesquisarDetalhesItem(String nome, String telefone, String item) {
		UsuarioID usuario = new UsuarioID(nome, telefone);
		if (!this.usuarios.containsKey(usuario)) {
			throw new NullPointerException("Usuario invalido");
		}
		return this.usuarios.get(usuario).getItem(item).toString();
	}

	/**
	 * Esse método passa os paramêtros para o método de registro de empréstimo no
	 * Controller de Empréstimos.
	 * 
	 * @param nomeDono
	 *            nome do usuário dono do item
	 * @param telefoneDono
	 *            telefone do usuário dono do item
	 * @param nomeReceptor
	 *            nome do usuário que vai receber o item
	 * @param telefoneReceptor
	 *            telefone do usuário que vai receber o item
	 * @param nomeItem
	 *            nome do item a ser emprestado
	 * @param dataEmprestimo
	 *            data inicial do emprestimo
	 * @param periodo
	 *            periodo em dias até a devolução
	 */

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

		this.emprestimoController.registrarEmprestimo(dono, receptor, itemEmprestimo, dataEmprestimo, periodo);

	}

	/**
	 * Esse método passa os paramêtros para o método de devolução de empréstimo no
	 * Controller de Empréstimos.
	 * 
	 * @param nomeDono
	 *            nome do usuário dono do item
	 * @param telefoneDono
	 *            telefone do usuário dono do item
	 * @param nomeReceptor
	 *            nome do usuário que vai receber o item
	 * @param telefoneReceptor
	 *            telefone do usuário que vai receber o item
	 * @param nomeItem
	 *            nome do item a ser emprestado
	 * @param dataEmprestimo
	 *            data inicial do emprestimo
	 * @param dataDevolucao
	 *            data em que item foi devolvido
	 */

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

		this.emprestimoController.devolverItem(dono, receptor, itemEmprestimo, dataEmprestimo, dataDevolucao);

	}

	/**
	 * Lista os 10 usuários com as reputações mais baixas.
	 * 
	 * @return listagem de 10 usuários com reputações mais baixas.
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
	 * Lista os usuários do sistema que possuem reputação negativa.
	 * 
	 * @return listagem dos usuários caloteiros.
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
	 * Lista os 10 usuários com as reputações mais altas.
	 * 
	 * @return listagem de 10 usuários com as melhores reputações.
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

	/**
	 * Listagem de itens dos usuários que não estão sendo emprestados.
	 * 
	 * @return lista itens que estão disponíveis.
	 */

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

	/**
	 * Lista os 10 itens mais emprestados.
	 * 
	 * @return listagem com os itens mais emprestados.
	 */

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

	/**
	 * Valida se um usuário existe.
	 * 
	 * @param nome
	 *            nome do usuário
	 * @param telefone
	 *            telefone do usuário
	 */

	public void validaUsuario(String nome, String telefone) {
		if (!this.usuarios.containsKey(new UsuarioID(nome, telefone))) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	/*
	 * Métodos que passam paramêtros para o Controller de Empréstimos.
	 */

	public String listarEmprestimosEmprestando(String nome, String telefone) {
		this.validaUsuario(nome, telefone);
		return this.emprestimoController.listarEmprestimosEmprestando(nome, telefone);
	}

	public String listarEmprestimosPegandoEmprestado(String nome, String telefone) {
		this.validaUsuario(nome, telefone);
		return this.emprestimoController.listarEmprestimosPegandoEmprestado(nome, telefone);
	}

	public String listaEmprestimosItem(String nomeItem) {
		return this.emprestimoController.listaEmprestimosItem(nomeItem);

	}

	public String listarItensEmprestados() {
		return this.emprestimoController.listarItensEmprestados();

	}

}