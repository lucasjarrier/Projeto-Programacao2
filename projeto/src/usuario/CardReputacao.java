package usuario;

public enum CardReputacao {
	
	Noob("Sim"),
	Caloteiro("Nao"),
	FreeRyder("Sim"),
	BomAmigo("Sim");
	
	private String situacao;

	CardReputacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}
}
