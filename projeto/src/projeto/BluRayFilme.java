package projeto;

public class BluRayFilme extends BluRay {

	private String genero;
	private int ano;
	
	public BluRayFilme(String nome, double valor, int duracao, String classificacao, String genero, int ano) throws Exception {
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
		return "Filme: " + this.nome + System.lineSeparator() 
		+ "Duracao: " + this.getDuracao() + System.lineSeparator()
		+ "Classificacao: " + this.getClassificacao() + System.lineSeparator()
		+ "Ano: " + this.ano + System.lineSeparator()
		+ "Valor: R$ " + this.valor;
	}

}

