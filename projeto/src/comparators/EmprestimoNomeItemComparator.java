package comparators;

import java.io.Serializable;
import java.util.Comparator;
import emprestimo.Emprestimo;

/**
 * Classe que estabelece compara��o entre dois empr�stimos, tendo o nome do item
 * emprestado como param�tro.
 * 
 * @author Higor
 *
 */

public class EmprestimoNomeItemComparator implements Comparator<Emprestimo> {
	@Override
	public int compare(Emprestimo e1, Emprestimo e2) {
		return e1.getItemEmprestado().getNome().compareTo(e2.getItemEmprestado().getNome());
	}

}
