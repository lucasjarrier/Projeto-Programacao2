package item;

import java.util.Comparator;

public class ItemNomeComparator implements Comparator<Item> {

	@Override
	public int compare(Item i1, Item i2) {
		return i1.getNome().compareTo(i2.getNome());
	}
}