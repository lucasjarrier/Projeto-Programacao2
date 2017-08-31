package item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa��o de um jogo de tabuleiro, que al�m de herdar os atributos de Item,
 * possui uma cole��o de pe�as, um atributo indicando se est� completo ou n�o em rela��o ao 
 * n�mero de pe�as.
 * 
 * @author Higor
 *
 */

public class JogoDeTabuleiro extends Item implements Serializable {

	protected List<String> pecas;
	protected Pecas estadoJogo;
	
	/**
	 * Constr�i um jogo de tabuleiro a partir de um nome do jogo
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