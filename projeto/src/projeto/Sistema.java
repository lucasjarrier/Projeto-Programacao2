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

	public void cadastraUsuario(String nome, String email, String numero) {
		validaUsuario(nome, email, numero);
		Usuario usuario = new Usuario(nome, email, numero);
		this.usuarios.add(usuario);
	}

	public String exibeUsuario(int usuario) {

		return this.getUsuario(usuario).toString();
	}

	public void atualizaUsuario(int usuario, String nome, String email, String numero)  {
		validaUsuario(nome, email, numero);
		Usuario usuarioAtualizado = getUsuario(usuario);
		usuarioAtualizado.setNome(nome);
		usuarioAtualizado.setEmail(email);
		usuarioAtualizado.setNumero(numero);
	}

	public void deletaUsuario(int usuario)  {

		this.usuarios.remove(usuario - 1);
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
