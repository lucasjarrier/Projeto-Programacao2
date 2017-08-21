package projeto;

import easyaccept.EasyAccept;

public class Fachada {

	private Sistema sistema;

	public Fachada() {
		this.sistema = new Sistema();
	}

	public static void main(String[] args) {
		args = new String[] { "projeto.Fachada", "projeto/acceptance_test/us1_test.txt",
				"projeto/acceptance_test/us2_test.txt", "projeto/acceptance_test/us3_test.txt",
				"projeto/acceptance_test/us4_test.txt", "projeto/acceptance_test/us5_test.txt",
				"projeto/acceptance_test/us6_test.txt", "projeto/acceptance_test/us7_test.txt",
				"projeto/acceptance_test/us8_test.txt" };
		EasyAccept.main(args);
	}

	public void iniciarSistema() throws Exception {

	}

	/**
	 * METODOS DE CADASTRO.
	 */

	public void cadastrarUsuario(String nome, String email, String telefone)  {
		sistema.cadastrarUsuario(nome, email, telefone);
	}

	public void cadastrarBluRayFilme(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int ano) {
		sistema.cadastraFilme(nomeUsuario, telefone, nomeItem, preco, duracao, genero, classificacao, ano);
	}

	public void cadastrarBluRaySerie(String nomeUsuario, String telefone, String nomeItem, double preco,
			String descricao, int duracao, String genero, String classificacao, int temporada) {
		sistema.cadastraSerie(nomeUsuario, telefone, nomeItem, preco, descricao, duracao, genero, classificacao,
				temporada);
	}

	public void cadastrarBluRayShow(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			int faixas, String artista, String classificacao) {
		sistema.cadastraShow(nomeUsuario, telefone, nomeItem, preco, duracao, faixas, artista, classificacao);
	}

	public void cadastrarEletronico(String nomeUsuario, String telefone, String nomeItem, double preco,
			String plataforma) {
		sistema.cadastraEletronico(nomeUsuario, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nomeUsuario, String telefone, String nomeItem, double preco) {
		sistema.cadastraJogoTabuleiro(nomeUsuario, telefone, nomeItem, preco);
	}

	/**
	 * METODOS DE MANIPULA��O.
	 */

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return sistema.getInfoUsuario(nome, telefone, atributo);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		sistema.atualizarUsuario(nome, telefone, atributo, valor);
	}

	public void removerUsuario(String nome, String numero) {
		sistema.removerUsuario(nome, numero);
	}

	public void atualizarItem(String nomeUsuario, String telefone, String nomeItem, String atributo, String valor) {
		sistema.atualizaItem(nomeUsuario, telefone, nomeItem, atributo, valor);
	}

	public void removerItem(String nomeUsuario, String telefone, String nomeItem) {
		sistema.removerItem(nomeUsuario, telefone, nomeItem);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public String getInfoItem(String nomeUsuario, String telefone, String nomeItem, String atributo) {
		return sistema.getInfoItem(nomeUsuario, telefone, nomeItem, atributo);
	}

	public void adicionarBluRay(String nomeUsuario, String telefone, String nomeBlurayTemporada, int duracao) {
		sistema.adicionarBluRay(nomeUsuario, telefone, nomeBlurayTemporada, duracao);
	}

	/**
	 * METODOS DE ORDENACAO.
	 */

	public String listarItensOrdenadosPorNome() {
		return sistema.listarItensOrdenadosPorNome();
	}

	public String listarItensOrdenadosPorValor() {
		return sistema.listarItensOrdenadosPorValor();
	}

	public String listarCaloteiros() {
		return sistema.listarCaloteiros();
	}

	public String listarTop10MelhoresUsuarios() {
		return sistema.listarTop10MelhoresUsuarios();
	}

	public String listarTop10PioresUsuarios() {
		return sistema.listarTop10PioresUsuarios();
	}

	/**
	 * METODOS DE EXIBICAO.
	 */

	public String pesquisarDetalhesItem(String nome, String telefone, String item) {
		return sistema.pesquisarDetalhesItem(nome, telefone, item);
	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		return sistema.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return sistema.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}

	public String listarEmprestimosItem(String nomeItem) {
		return sistema.listarEmprestimosItem(nomeItem);
	}

	public String listarItensNaoEmprestados() {
		return sistema.listarItensNaoEmprestados();
	}

	public String listarItensEmprestados() {
		return sistema.listarItensEmprestados();
	}

	public String listarTop10Itens() {
		return sistema.listarTop10Itens();
	}

	/**
	 * METODOS DE EMPRESTIMO.
	 */

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeReceptor, String telefoneReceptor,
			String item, String dataEmprestimo, int periodo) {
		this.sistema.registrarEmprestimo(nomeDono, telefoneDono, nomeReceptor, telefoneReceptor, item, dataEmprestimo,
				periodo);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeReferente, String telefoneReferente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		this.sistema.devolverItem(nomeDono, telefoneDono, nomeReferente, telefoneReferente, nomeItem, dataEmprestimo,
				dataDevolucao);
	}

	/**
	 *  COMANDO FECHAR SISTEMA.
	 */
	
	public void fecharSistema() {

	}
}