package comparators;

import java.io.Serializable;
import java.util.Comparator;
import emprestimo.Emprestimo;

/**
 * Classe que estabelece comparação entre dois empréstimos, tendo o nome do item
 * emprestado como paramêtro.
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
