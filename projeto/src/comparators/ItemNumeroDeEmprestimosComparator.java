package comparators;

import java.io.Serializable;
import java.util.Comparator;

import item.Item;

/**
 * Classe que estabelece compara��o entre dois itens, tendo o n�mero de vezes
 * que o item foi emprestado como param�tro.
 * 
 * @author Higor
 *
 */

public class ItemNumeroDeEmprestimosComparator implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		int it1 = (int) item1.getNumeroDeEmprestimos();
		int it2 = (int) item2.getNumeroDeEmprestimos();

		if (it1 < it2) {
			return 1;

		} else if (it1 > it2) {
			return -1;

		} else {

			return 0;
		}
	}

}
