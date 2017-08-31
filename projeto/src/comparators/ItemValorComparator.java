
package comparators;

import java.io.Serializable;
import java.util.Comparator;

import item.Item;

/**
 * Classe que estabelece comparação entre itens, tendo o valor do item como
 * paramêtro de comparação.
 * 
 * @author Higor
 *
 */

public class ItemValorComparator implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {

		int it1 = (int) item1.getValor();
		int it2 = (int) item2.getValor();

		if (it1 < it2) {
			return -1;

		} else if (it1 > it2) {
			return 1;

		} else {

			return 0;
		}
	}
}