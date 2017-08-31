package cartoes;

import java.io.Serializable;

/**
 * Representação de um cartão de reputação FreeRyder. 
 * 
 * @author Higor
 *
 */

public class CardFreeRyder implements CardReputacao, Serializable {

	public static final int PERIODO_MAXIMO = 5;
	
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
		return "FreeRyder";
	}

}
