package cartoes;

/**
 * Interface que possui o contrato de dois m�todos, que calcula o limite de
 * tempo que um usu�rio pode pegar um item emprestado e se ele pode pegar
 * emprestado, de acordo com o tipo do seu cart�o.
 * 
 * @author Higor
 *
 */

public interface CardReputacao {

	public int getPeriodoMaximo();

	public boolean pegarEmprestado();

}
