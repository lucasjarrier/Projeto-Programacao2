package item;

/**
 * Representa��o do estado do jogo de tabuleiro em rela��o as pe�as.
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