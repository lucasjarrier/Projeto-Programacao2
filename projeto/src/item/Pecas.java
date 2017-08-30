package item;

/**
 * Representação do estado do jogo de tabuleiro em relação as peças.
 * 
 * @author Higor
 *
 */

public enum Pecas {

	COMPLETO("COMPLETO"), INCOMPLETO("COM PECAS PERDIDAS");

	private String estado;

	Pecas(String estado) {
		this.estado = estado;
	}

	public String getEstadoJogo() {
		return estado;
	}

}