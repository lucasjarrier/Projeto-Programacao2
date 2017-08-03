package projeto;

public class BluRaySerie extends BluRay {
	
	private String descricao;
	private String genero;
	private int temporada;
	
	public BluRaySerie(String nome, double valor, int duracao, String classificacao, String descricao,
			String genero, int temporada) throws Exception {
		super(nome, valor, duracao, classificacao);
		this.descricao = descricao;
		this.genero = genero;
		this.temporada = temporada;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public int getTemporada() {
		return temporada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + temporada;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BluRaySerie other = (BluRaySerie) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (temporada != other.temporada)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Serie: " + nome + System.lineSeparator() 
		+ "Duracao: " + this.getDuracao() + System.lineSeparator()
		+ "Classificacao: " + this.getClassificacao() + System.lineSeparator()
		+ "Genero: " + this.genero + System.lineSeparator()
		+ "Temporada: " + this.temporada + System.lineSeparator()
		+ "Valor: R$ " + this.valor;
	}

	
}