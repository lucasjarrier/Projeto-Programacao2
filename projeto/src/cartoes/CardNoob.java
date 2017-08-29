package cartoes;

public class CardNoob implements CardReputacao {

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
