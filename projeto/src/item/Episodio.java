package item;

/**
 * Representação de um episódio, todo é episódio é representado por uma duração.
 * 
 * @author Higor
 *
 */

public class Episodio {
	private int duracao;

	/**
	 * Constrói um episódio a partir de uma duração
	 * 
	 * @param duracao
	 *            duracao do episódio
	 */

	public Episodio(int duracao) {
		this.duracao = duracao;
	}

	public int getDuracao() {
		return duracao;
	}

}
