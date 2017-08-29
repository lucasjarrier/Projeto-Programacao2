package comparators;

import java.util.Comparator;

import item.Item;

public class ItemNomeComparator implements Comparator<Item> {

	@Override
	public int compare(Item i1, Item i2) {
		return i1.getNome().compareTo(i2.getNome());
	}
}