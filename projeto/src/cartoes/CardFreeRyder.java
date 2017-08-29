package cartoes;

public class CardFreeRyder implements CardReputacao {

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
