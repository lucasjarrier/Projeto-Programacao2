package cartoes;

import java.io.Serializable;

/*
 * Representa��o de um cart�o de reputa��o Caloteiro. 
 * 
 */

public class CardCaloteiro implements CardReputacao, Serializable {

	public static final int PERIODO_MAXIMO = 0;
	
	@Override
	public int getPeriodoMaximo() {
		return PERIODO_MAXIMO;
	}

	@Override
	public boolean pegarEmprestado() {
		return false;
	}

	@Override
	public String toString() {
		return "Caloteiro";
	}

}
