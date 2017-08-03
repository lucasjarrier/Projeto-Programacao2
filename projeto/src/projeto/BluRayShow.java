package projeto;

public class BluRayShow  extends BluRay {

	private String artista;
	private int faixas;
	
	public BluRayShow(String nome, double valor, int duracao, String classificacao, String artista, int faixas) throws Exception {
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
		return "Show: " + nome + System.lineSeparator()
		+ "Duracao: " + this.getDuracao() + System.lineSeparator()
		+ "Classificacao: " + this.getClassificacao() + System.lineSeparator()
		+ "Artista: " + this.artista + System.lineSeparator()
		+ "Faixas: " + this.faixas + System.lineSeparator()
		+ "Valor: R$ " + this.valor;
	}
	
}
