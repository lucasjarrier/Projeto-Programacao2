package comparators;

import java.util.Comparator;

import usuario.Usuario;

/**
 * Classe que estabelece comparação entre dois usuários, tendo a reputação do
 * usuário como parâmetro.
 * 
 * @author Higor
 *
 */

public class MelhoresUsuariosReputacaoComparator implements Comparator<Usuario> {

	@Override
	public int compare(Usuario usuario1, Usuario usuario2) {

		double user1 = (double) usuario1.getReputacao();
		double user2 = (double) usuario2.getReputacao();

		if (user1 > user2) {
			return -1;

		} else if (user1 < user2) {
			return 1;

		} else {

			return 0;
		}
	}
}