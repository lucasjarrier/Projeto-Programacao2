package jogos;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class JogoDeTabuleiro extends Item {

	protected List<String> pecas;
	protected boolean completo;
	protected Pecas estadoJogo;

	public JogoDeTabuleiro(String nome, double valor) throws Exception {
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

	public void adicionaPecaPerdida(String peca) {
		pecas.add(peca);
	}

	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + this.nome + ", R$ " + this.valor + ", " + this.estado + ", " + this.estadoJogo.getEstadoJogo();
	}
}
