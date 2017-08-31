package emprestimo;

import java.io.Serializable;

import item.Item;
import usuario.Usuario;

/**
 * Representa��o de um identificador para acesso de um emprestimo registrado no
 * sistema.
 * 
 * @author Higor
 *
 */

public class EmprestimoID implements Serializable {
	private Usuario donoItem;
	private Usuario usuarioReceptor;
	private Item itemEmprestado;

	/**
	 * Como todo empr�stimo � reconhecido a partir do dono do item, o usuario
	 * recetor e o item que est� sendo emprestado, ent�o o identificador �
	 * constru�do a parter desses par�metros.
	 * 
	 * @param donoItem
	 *            Usuario que possui o item
	 * @param usuarioReceptor
	 *            Usuario que quer o item emprestado
	 * @param itemEmprestado
	 *            Item que ser� emprestado
	 */

	public EmprestimoID(Usuario donoItem, Usuario usuarioReceptor, Item itemEmprestado) {
		this.donoItem = donoItem;
		this.usuarioReceptor = usuarioReceptor;
		this.itemEmprestado = itemEmprestado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((donoItem == null) ? 0 : donoItem.hashCode());
		result = prime * result + ((itemEmprestado == null) ? 0 : itemEmprestado.hashCode());
		result = prime * result + ((usuarioReceptor == null) ? 0 : usuarioReceptor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmprestimoID other = (EmprestimoID) obj;
		if (donoItem == null) {
			if (other.donoItem != null)
				return false;
		} else if (!donoItem.equals(other.donoItem))
			return false;
		if (itemEmprestado == null) {
			if (other.itemEmprestado != null)
				return false;
		} else if (!itemEmprestado.equals(other.itemEmprestado))
			return false;
		if (usuarioReceptor == null) {
			if (other.usuarioReceptor != null)
				return false;
		} else if (!usuarioReceptor.equals(other.usuarioReceptor))
			return false;
		return true;
	}

}
