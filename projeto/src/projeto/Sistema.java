package projeto;

import java.util.ArrayList;

public class Sistema {

	private ArrayList<Usuario> usuarios;

	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public Usuario getUsuario(int usuario) {
		return this.usuarios.get(usuario - 1);
	}
		
	public String getInfoUsuario(String nome, String numero, String atributo) {
		
	}
	
	public void cadastraUsuario(String nome, String email, String numero) {
		validador.validaCadastro(nome,email,numero);
		
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
		validador.validaRemover(nome, numero);
		
		for (int i = 0; i < usuarios.size(); i++) {
		    if (this.usuarios.get(i).getNome().equals(nome) && this.usuarios.get(i).getNumero().equals(numero)) {
		      this.usuarios.remove(i);
		    }
		}
		
	}

	public void cadastraItem(int usuario, String nome) {
		this.getUsuario(usuario).adicionaItem(nome);
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
