package jogos;

import item.Item;

public class JogoEletronico extends Item {

	protected String plataforma;

	public JogoEletronico(String nome, double valor, String plataforma) throws Exception {
		super(nome, valor);
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}

	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + this.nome + ", R$" + this.valor + ", " + this.estado.getSituacao() + ", " + this.plataforma;
	}
}
