package item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de um jogo de tabuleiro, que além de herdar os atributos de Item,
 * possui uma coleção de peças, um atributo indicando se está completo ou não em relação ao 
 * número de peças.
 * 
 * @author Higor
 *
 */

public class JogoDeTabuleiro extends Item implements Serializable {

	protected List<String> pecas;
	protected Pecas estadoJogo;
	
	/**
	 * Constrói um jogo de tabuleiro a partir de um nome do jogo
	 * e um valor.
	 * 
	 * @param nome nome do jogo
	 * @param valor valor do jogo
	 */

	public JogoDeTabuleiro(String nome, double valor) {
		super(nome, valor);
		this.pecas = new ArrayList<String>();
		this.estadoJogo = Pecas.COMPLETO;
	}

	public void adicionaPecaPerdida(String peca) {
		pecas.add(peca);
		this.estadoJogo = Pecas.INCOMPLETO;
	}

	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + this.nome + ", R$ " + this.valor + ", " + this.estado.getSituacao() + ", " + this.estadoJogo.getEstadoJogo();
	}
}