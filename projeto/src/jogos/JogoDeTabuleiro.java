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