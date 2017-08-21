package emprestimo;

import java.util.Comparator;

public class EmprestimoNomeItemComparator implements Comparator<Emprestimo> {
	@Override
	public int compare(Emprestimo e1, Emprestimo e2) {
		return e1.getItemEmprestado().getNome().compareTo(e2.getItemEmprestado().getNome());
	}

}
