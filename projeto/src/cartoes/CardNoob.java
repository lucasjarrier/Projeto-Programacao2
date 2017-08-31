package cartoes;

import java.io.Serializable;

/**
 * Representa��o de um cart�o de reputa��o Noob. 
 * 
 * @author Higor
 *
 */

public class CardNoob implements CardReputacao, Serializable {

	public static final int PERIODO_MAXIMO = 7;
	
	@Override
	public int getPeriodoMaximo() {
		return PERIODO_MAXIMO;
	}

	@Override
	public boolean pegarEmprestado() {
		return true;
	}

	@Override
	public String toString() {
		return "Noob";
	}

}
