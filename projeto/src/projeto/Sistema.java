package projeto;

import java.util.ArrayList;

import item.EstadoItem;

public class Sistema {

	private ArrayList<Usuario> usuarios;

	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public Usuario getUsuario(int usuario) {
		return this.usuarios.get(usuario - 1);
	}
		
	public void getInfoUsuario(String nome, String numero, String atributo) {
		// falta implementar
	}
	
	public void cadastraUsuario(String nome, String email, String numero) {
		Validador.validaUsuario(nome, email, numero);
		Usuario novoUsuario = new Usuario(nome, email, numero);
		this.usuarios.add(novoUsuario);

	}

	public String exibeUsuario(int usuario) {

		return this.getUsuario(usuario).toString();
	}

	public void atualizaUsuario(String nome, String email, String numero, String atributo, String valor) {
			
			for (Usuario usuario : usuarios) {
				if (usuario.getNome().equals(nome) && usuario.getNumero().equals(numero)) {
					if (atributo == "Nome") {
	                	usuario.setNome(valor);
	                }
	            	if (atributo == "Email") {
	            		usuario.setNome(valor);
	            	}
	            	if (atributo == "Numero") {
	            		usuario.setNumero(valor);
	            	}
	            }
			}
		}

	public void removerUsuario(String nome, String numero) throws Exception {
		for (int i = 0; i < usuarios.size(); i++) {
		    if (this.usuarios.get(i).getNome().equals(nome) && this.usuarios.get(i).getNumero().equals(numero)) {
		      this.usuarios.remove(i);
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
	
	

}
