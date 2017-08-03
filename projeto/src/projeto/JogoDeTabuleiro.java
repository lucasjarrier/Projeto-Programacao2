package projeto;

import java.util.ArrayList;
import java.util.List;

public class JogoDeTabuleiro extends Item {

	protected List<String> pecas;
	protected boolean completo;
	protected Pecas estadoJogo;

	public JogoDeTabuleiro(String nome, double valor, boolean completo) throws Exception {

		super(nome, valor);
		this.pecas = new ArrayList<String>();

		if (pecas.size() == 0) {
			this.completo = true;
			this.estadoJogo = Pecas.COMPLETO;
		} else {
			this.completo = false;
			this.estadoJogo = Pecas.INCOMPLETO;
		}
	}

	public void adicionaPecaPerdida() {
		/*
		 * Falta Implementar! 
		 * Adicionar a pessoa que perdeu a pe�a: "Quem perdeu tal pe�a?"
		 */
	}

	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + this.nome + ", R$ " + this.valor + ", " + this.estado + ", " + this.estadoJogo.getEstadoJogo();
	}
}
