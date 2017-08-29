package cartoes;

public class CardBomAmigo implements CardReputacao {

	public static final int PERIODO_MAXIMO = 15;
	
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
		return "BomAmigo";
	}

}
