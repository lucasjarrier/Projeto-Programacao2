package projeto;

import java.util.Comparator;

/**
 *  Classe comparator, ela é responsavel por comparar o nome entre dois itens.
 */

import item.Item;

public class NomeComparator implements Comparator<Item> {

	@Override
	public int compare(Item i1, Item i2) {
		return i1.getNome().compareTo(i2.getNome());
	}
}