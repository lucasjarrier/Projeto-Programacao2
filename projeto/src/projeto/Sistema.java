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
