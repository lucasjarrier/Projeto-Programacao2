package item;

import java.io.Serializable;

/**
 * Representa��o de um epis�dio, todo � epis�dio � representado por uma dura��o.
 * 
 * @author Higor
 *
 */

public class Episodio implements Serializable {
	private int duracao;

	/**
	 * Constr�i um epis�dio a partir de uma dura��o
	 * 
	 * @param duracao
	 *            duracao do epis�dio
	 */

	public Episodio(int duracao) {
		this.duracao = duracao;
	}

	public int getDuracao() {
		return duracao;
	}

}
