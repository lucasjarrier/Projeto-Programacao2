package item;

/**
 * Representação de uma classe abstrata BlueRay que é representada por um nome,
 * valor, duracao, e a classificação indicativa.
 * 
 * @author Higor
 *
 */

public abstract class BluRay extends Item {
	//Atributos
	private int duracao;
	private String classificacao;
	
	/**
	 * Constrói um BluRay a partir do nome, valor, duracao e classificação.
	 * 
	 * @param nome nome do bluray
	 * @param valor valor do bluray
	 * @param duracao duracao do bluray
	 * @param classificacao classificação indicatica do bluray
	 */
	
	public BluRay(String nome, double valor, int duracao, String classificacao) {
		super(nome, valor);
		this.duracao = duracao;
		this.classificacao = classificacao;
	}
	
	public int getDuracao() {
		return duracao;
	}

	public String getClassificacao() {
		return classificacao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result + duracao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		BluRay other = (BluRay) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
