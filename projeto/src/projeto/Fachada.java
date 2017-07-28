package projeto;

public class Fachada {

	public static void main(String[] args) {
		args = new String[] {"Arquivos de Teste"};
	    // EasyAccept.main(args);
		
	}
	private Sistema sistema;
	
	public void inicializaSitema() throws Exception {
		this.sistema = new Sistema();
	}
	/**
	 * METODOS DE CADASTRO.
	 */
	public void cadastrarUsuario(String nome, String email, String telefone) throws Exception {
		sistema.cadastraUsuario(nome,email,telefone);
	}
	public void cadastraItens(String nome) throws Exception {
		sistema.cadastraItens(nome);
	}

	/**
	 * METODOS DE MANIPULAÇÃO.
	 */

	public void atualizaUsuario(int posicao,String nome, String email, String telefone) throws Exception {
		sistema.atualizaUsuario(posicao, nome, email, telefone);
	}
	
	public void deletaUsuario(int posicao) throws Exception {
		sistema.deletaUsuario(posicao);
	}
}
