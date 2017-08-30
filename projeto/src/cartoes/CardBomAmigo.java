package cartoes;

/**
 * Representação de um cartão de reputação Bom Amigo. 
 * 
 * @author Higor
 *
 */

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
