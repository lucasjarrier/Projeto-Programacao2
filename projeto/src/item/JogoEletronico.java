package item;

/**
 * Representação de um jogo eletrônico, que além de ser representado pelos
 * atributos da classe que é herdeira, também é representado por uma plataforma.
 * 
 * @author Higor
 *
 */

public class JogoEletronico extends Item {

	protected String plataforma;

	/**
	 * Constrói um jogo eletrônico a partir de um nome, valor, e respectiva
	 * plataforma.
	 * 
	 * @param nome
	 *            nome do jogo
	 * @param valor
	 *            valor do jogo
	 * @param plataforma
	 *            plataforma suportada
	 */

	public JogoEletronico(String nome, double valor, String plataforma) {
		super(nome, valor);
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}

	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + this.nome + ", R$ " + this.valor + ", " + this.estado.getSituacao() + ", "
				+ this.plataforma;
	}
}