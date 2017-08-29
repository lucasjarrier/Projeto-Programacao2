package item;

public class BluRayFilme extends BluRay {

	private String genero;
	private int ano;
	
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
