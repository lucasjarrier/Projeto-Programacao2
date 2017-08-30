package comparators;

import java.util.Comparator;
import item.Item;

/**
 * Classe que estabelece compara��o entre dois itens, tendo o nome do item
 * como param�tro.
 * 
 * @author Higor
 *
 */

public class ItemNomeComparator implements Comparator<Item> {

	@Override
	public int compare(Item i1, Item i2) {
		return i1.getNome().compareTo(i2.getNome());
	}
}