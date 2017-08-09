package projeto;

import easyaccept.EasyAccept;
import item.EstadoItem;

public class Fachada {

	public static void main(String[] args) {
		args = new String[] {"projeto.Fachada", "projeto/acceptance_test/us1_test.txt", "projeto/acceptance_test/us2_test.txt",
				"projeto/acceptance_test/us3_test.txt", "projeto/acceptance_test/us4_test.txt"};
	    EasyAccept.main(args);
		
	}
	private Sistema sistema;
	
	public void iniciarSistema() throws Exception {
		this.sistema = new Sistema();
	}
	
	/**
	 * METODOS DE CADASTRO.
	 */
	
	public void cadastrarUsuario(String nome, String email, String telefone) throws Exception {
		sistema.cadastraUsuario(nome,email,telefone);
	}
	
	public void cadastrarBluRayFilme(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int ano) throws Exception {
		sistema.cadastraFilme(nomeUsuario, telefone, nomeItem, preco, duracao, genero, classificacao, ano);
	}
	
	public void cadastrarBluRaySerie(String nomeUsuario, String telefone, String nomeItem, double preco, String descricao, int duracao,
			String genero, String classificacao, int temporada) throws Exception {
		sistema.cadastraSerie(nomeUsuario, telefone, nomeItem, preco, descricao, duracao, genero, classificacao, temporada);
	}

	public void cadastrarBluRayShow(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao, int faixas,
			String artista, String classificacao) throws Exception {
		sistema.cadastraShow(nomeUsuario, telefone, nomeItem, preco, duracao, faixas, artista, classificacao);
	}
	
	public void cadastrarEletronico(String nomeUsuario, String telefone, String nomeItem, 
			double preco, String plataforma) throws Exception {
		sistema.cadastraEletronico(nomeUsuario, telefone, nomeItem, preco, plataforma);
	}
	
	public void cadastrarJogoTabuleiro(String nomeUsuario, String telefone, String nomeItem, double preco) throws Exception {
		sistema.cadastraJogoTabuleiro(nomeUsuario, telefone, nomeItem, preco);
	}
	
	/**
	 * METODOS DE MANIPULA��O.
	 */

	public void getInfoUsuario(String nome, String telefone, String atributo) throws Exception {
		sistema.getInfoUsuario(nome, telefone, atributo);
	}
	public void atualizarUsuario(String nome, String telefone, String email, String atributo, String valor) throws Exception {
		sistema.atualizarUsuario(nome, telefone, email, atributo, valor);
	}
	
	public void removerUsuario(String nome, String numero) throws Exception {
		sistema.removerUsuario(nome, numero);
	}
	
	public void atualizarItem(String nomeUsuario, String telefone, String nomeItem, String atributo, String valor) throws Exception {
		sistema.atualizaItem(nomeUsuario, telefone, nomeItem, atributo, valor);
	}
	
	public void removerItem(String nomeUsuario, String telefone, String nomeItem) throws Exception {
		sistema.removerItem(nomeUsuario, telefone, nomeItem);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}
	
	public void getInfoItem(String nomeUsuario, String telefone, String nomeItem, String atributo) throws Exception {
		sistema.getInfoItem(nomeUsuario, telefone, nomeItem, atributo);
	}

	/**
	 *  METODOS DE ORDENACAO.
	 */
	
	public String listarItensOrdenadosPorNome() {
		return sistema.listarItensOrdenadosPorNome();
	}
	public String listarItensOrdenadosPorValor() {
		return sistema.listarItensOrdenadosPorValor();
	}
	
	/**
	 *  METODOS DE EXIBICAO.
	 * @throws Exception 
	 */
	
	public String pesquisarDetalhesItem(String nomeItem, String nomeUsuario, String numeroUsuario) {
		return sistema.pesquisarDetalhesItem(nomeItem, nomeUsuario, numeroUsuario);
	}
}
