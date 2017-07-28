package projeto;

public enum EstadoItem {
	
	DISPONIVEL("N�o emprestado"), 
	INDISPONIVEL("Emprestado");

	private String situacao;
	
	EstadoItem(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}
}