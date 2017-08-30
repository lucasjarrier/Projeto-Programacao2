package item;

/**
 * Representa��o do estado de um item em rela��o a sua disponibilidade, se est�
 * emprestado ou n�o.
 * 
 * @author Higor
 *
 */

public enum EstadoItem {

	DISPONIVEL("Nao emprestado"), INDISPONIVEL("Emprestado");

	private String situacao;

	EstadoItem(String situacao) {
		this.situacao = situacao;
	}

	public String getSituacao() {
		return situacao;
	}
}