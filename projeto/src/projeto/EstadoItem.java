package projeto;

public enum EstadoItem {
	
	DISPONIVEL("Não emprestado"), 
	INDISPONIVEL("Emprestado");

	private String situacao;
	
	EstadoItem(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}
}