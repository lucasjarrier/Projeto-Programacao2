package projeto;

public class Validador {

	public static void validaUsuario(String nome, String email, String numero) throws IllegalArgumentException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		if (numero == null || numero.trim().isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}
	
	public static void validaBluray()
}
