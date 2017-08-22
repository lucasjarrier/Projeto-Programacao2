package usuario;

public enum CartaoReputacao {
	
	Noob("Sim"),
	Caloteiro("Nao"),
	FreeRyder("Sim"),
	BomAmigo("Sim");
	
	private String situacao;

	CartaoReputacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}
}
