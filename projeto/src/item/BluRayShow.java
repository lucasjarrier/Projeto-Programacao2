package item;

import java.io.Serializable;

/**
 * Representação de uma classe BlueRaySerie que é representada por um nome,
 * valor, duracao, e a classificação indicativa, nome do artista e numero de
 * faixas.
 * 
 * @author Higor
 *
 */

public class BluRayShow  extends BluRay implements Serializable {

	private String artista;
	private int faixas;
	
	/**
	 * Constrói um BluRaySerie a partir de um nome, valor, duracao, classificacao
	 * indicativa, nome do artista e número de faixas.
	 * 
	 * @param nome
	 * @param valor
	 * @param duracao
	 * @param classificacao
	 * @param artista
	 * @param faixas
	 */
	
	public BluRayShow(String nome, double valor, int duracao, String classificacao, String artista, int faixas) {
		super(nome, valor, duracao, classificacao);
		this.artista = artista;
		this.faixas = faixas;
	}
	
	public String getArtista() {
		return artista;
	}

	public int getFaixas() {
		return faixas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + faixas;
		return result;
	}


	@Override
	public String toString() {
		return "SHOW: " + this.nome + ", R$ " + this.valor + ", " + this.estado.getSituacao() + ", " + this.getDuracao() + " min, "
				+ this.getClassificacao() + ", " + this.artista + ", " + this.faixas + " faixas";
	}
	
}
