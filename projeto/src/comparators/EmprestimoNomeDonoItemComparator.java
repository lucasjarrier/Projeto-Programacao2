package comparators;

import java.util.Comparator;
import emprestimo.Emprestimo;

/**
 * Classe que estabelece compara��o entre dois empr�stimos, tendo o nome do usu�rio
 * dono do item como param�tro.
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
