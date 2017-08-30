package utils;

/**
 * Entidade que valida métodos do sistema, checando possíveis erros de entrada.
 * 
 * @author Higor
 *
 */

public class Validador {

	public static void validaUsuario(String nome, String email, String telefone) throws IllegalArgumentException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (telefone == null || telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}

	}

	public static void validaRemover(String nome, String telefone) throws IllegalArgumentException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (telefone == null || telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	public static void validaAtualizar(String nome, String telefone, String valor, String atributo)
			throws IllegalArgumentException {
		if (nome.equals(null) || nome.trim().equals("")) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (telefone.equals(null) || telefone.trim().equals("")) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (valor.equals(null) || valor.trim().equals("")) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (atributo.equals(null) || atributo.trim().equals("")) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	public static void validaInfoUsuario(String nome, String telefone, String atributo)
			throws IllegalArgumentException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (telefone == null || telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (atributo == null || atributo.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	/**
	 * 
	 * Validador do metodo pesquisaItem de Sistema, retorna as exceções.
	 */

	public static void validaPesquisaItem(String nomeItem, String nomeUsuario, String telefoneUsuario) {

		if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (telefoneUsuario == null || telefoneUsuario.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (nomeItem == null || nomeItem.trim().isEmpty()) {
			throw new IllegalArgumentException("Item invalido");
		}
	}

}
