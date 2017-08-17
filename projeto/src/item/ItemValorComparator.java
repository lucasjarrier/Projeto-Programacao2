
package item;

/**
 *  Classe comparator, ela 
 */

import java.util.Comparator;

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