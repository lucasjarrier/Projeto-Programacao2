package cartoes;

/**
 * Interface que possui o contrato de dois métodos, que calcula o limite de
 * tempo que um usuário pode pegar um item emprestado e se ele pode pegar
 * emprestado, de acordo com o tipo do seu cartão.
 * 
 * @author Higor
 *
 */

public interface CardReputacao {

	public int getPeriodoMaximo();

	public boolean pegarEmprestado();

}
