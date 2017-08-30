package item;

/**
 * Representação do estado de um item em relação a sua disponibilidade, se está
 * emprestado ou não.
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