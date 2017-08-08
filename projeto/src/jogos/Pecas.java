package jogos;

public enum Pecas {

	COMPLETO("COMPLETO"),
	INCOMPLETO("COM PECAS PERDIDAS");
	
	private String estado;
	
	Pecas(String estado) {
		this.estado = estado;
	}
	
	public String getEstadoJogo() {
		return estado;
	}
	
}
