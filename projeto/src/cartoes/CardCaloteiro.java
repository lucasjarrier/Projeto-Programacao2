package cartoes;

/*
 * Representação de um cartão de reputação Caloteiro. 
 * 
 */

public class CardCaloteiro implements CardReputacao {

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
