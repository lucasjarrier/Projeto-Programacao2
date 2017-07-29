package projeto;

import java.util.ArrayList;

public class Sistema {

	private ArrayList<Usuario> usuarios;

	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public void validaUsuario(String erro, int usuario) throws IllegalArgumentException {
		if (usuario <= 0) {
			throw new IllegalArgumentException(erro + "Usuario invalido");
		} else if (usuario > usuarios.size()) {
			throw new IllegalArgumentException(erro + "Usuario nao cadastrado");
		}
	}

	public Usuario getUsuario(int usuario) {
		return this.usuarios.get(usuario - 1);
	}

	public void cadastraUsuario(String nome, String email, String numero) {

		Usuario novoUsuario = new Usuario(nome, email, numero);
		this.usuarios.add(novoUsuario);
	}

	public String exibeUsuario(int usuario) throws Exception {
		validaUsuario("Erro ao exibir usuario: ", usuario);

		return this.getUsuario(usuario).toString();
	}

	public void atualizaUsuario(int usuario, String nome, String email, String numero) throws Exception {
		validaUsuario("Erro ao atualizar usuario: ", usuario);

		Usuario usuarioAtualizado = getUsuario(usuario);

		usuarioAtualizado.setNome(nome);
		usuarioAtualizado.setEmail(email);
		usuarioAtualizado.setNumero(numero);
	}

	public void deletaUsuario(int usuario) throws Exception {
		validaUsuario("Erro ao deletar usuario: ", usuario);

		this.usuarios.remove(usuario - 1);
	}

	public void cadastraItem(int usuario, String nome) throws Exception {
		validaUsuario("Erro ao cadastrar item", usuario);

		if (nome == null || nome.trim().isEmpty()) {
			throw new Exception("Erro ao cadastrar item: Nome nao pode ser vazio ou nulo");
		}

		this.getUsuario(usuario).adicionaItem(nome);
	}

	public String exibeItens(int usuario) {
		validaUsuario("Erro ao exibir itens: ", usuario);

		return this.getUsuario(usuario).exibirItens();
	}

	public void atualizaItem(int usuario, int item, EstadoItem estado) {

		if (usuario <= 0) {
			throw new IllegalArgumentException("Erro ao atualizar item: Usuario inválido");
		}
		if (usuario > usuarios.size()) {
			throw new IllegalArgumentException("Erro ao atualizar item: Usuario não cadastrado");
		}
		if (item <= 0) {
			throw new IllegalArgumentException("Erro ao atualizar item: Item inválido");
		}
		if (item > usuarios.get(usuario).getItens().size()) {
			throw new IllegalArgumentException("Erro ao atualizar item: Item não cadastrado");
		}

		/*
		 * FALTA IMPLEMENTAR ...
		 */
	}

	public void deletaItem(int usuario, int item) {

		if (usuario <= 0) {
			throw new IllegalArgumentException("Erro ao deletar item: Usuario inválido");
		}
		if (usuario > usuarios.size()) {
			throw new IllegalArgumentException("Erro ao deletar item: Usuario não cadastrado");
		}
		if (item <= 0) {
			throw new IllegalArgumentException("Erro ao deletar item: Item inválido");
		}
		if (item > usuarios.get(usuario).getItens().size()) {
			throw new IllegalArgumentException("Erro ao deletar item: Item não cadastrado");
		}

	}
}
