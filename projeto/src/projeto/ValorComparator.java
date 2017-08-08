
package projeto;

import java.util.Comparator;

public class ValorComparator implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {

		int it1 = (int) item1.valor;
		int it2 = (int) item2.valor;

		if (it1 < it2) {
			return 1;

		} else if (it1 > it2) {
			return -1;

		} else {

			return 0;
		}
	}
}