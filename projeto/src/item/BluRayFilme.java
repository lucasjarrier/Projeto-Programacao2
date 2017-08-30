package item;

/**
 * Representação de uma classe BlueRayFilme que é representada por um nome,
 * valor, duracao, e a classificação indicativa.
 * 
 * @author Higor
 *
 */

public class BluRayFilme extends BluRay {
	//Atributos
	private String genero;
	private int ano;
	
	/**
	 * Constrói um BluRayFilme a partir de um nome, valor, duracao, classificacao
	 * indicativa genero do filme e o ano em que foi lançado.
	 * 
	 * @param nome
	 *            nome do filme
	 * @param valor
	 *            valor do filme
	 * @param duracao
	 *            duracao do filme
	 * @param classificacao
	 *            classificacao indicativa do filme
	 * @param genero
	 *            genero do filme
	 * @param ano
	 *            ano de lançamento do filme
	 */
	
	public BluRayFilme(String nome, double valor, int duracao, String classificacao, String genero, int ano) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.ano = ano;
	}
	
	public String getGenero() {
		return genero;
	}

	public int getAno() {
		return ano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ano;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		return result;
	}


	@Override
	public String toString() {
		return "FILME: " + this.nome + ", R$ " + this.valor + ", " + this.estado.getSituacao() + ", " + this.getDuracao() +
				" min, " + this.getClassificacao() + ", " + this.genero + ", " + this.ano; 
		
	}

}
