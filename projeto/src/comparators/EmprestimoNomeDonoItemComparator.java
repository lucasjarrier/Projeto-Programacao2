package comparators;

import java.util.Comparator;
import emprestimo.Emprestimo;

/**
 * Classe que estabelece comparação entre dois empréstimos, tendo o nome do usuário
 * dono do item como paramêtro.
 * 
 * @author Higor
 *
 */

public class EmprestimoNomeDonoItemComparator implements Comparator<Emprestimo> {

	@Override
	public int compare(Emprestimo e1, Emprestimo e2) {
		return e1.getDonoItem().getNome().compareTo(e2.getDonoItem().getNome());
	}

}
