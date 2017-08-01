package projeto;

import java.util.ArrayList;
import java.util.List;

public class JogoDeTabuleiro extends Item {

	protected List<String> pecas;
	protected boolean completo;
	protected String saida;

	public JogoDeTabuleiro(String nome, double valor, boolean completo) throws Exception {

		super(nome, valor);
		this.pecas = new ArrayList<String>();

		if (pecas.size() == 0) {
			this.completo = true;
			this.saida = "sim";
		} else {
			this.completo = false;
			this.saida = "n�o";
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
		return "Nome: " + this.nome + " Completo: " + this.saida;
	}
}
