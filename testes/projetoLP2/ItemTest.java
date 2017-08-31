package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.BluRay;
import item.BluRayFilme;
import item.JogoEletronico;
import item.JogoDeTabuleiro;

public class ItemTest {

	BluRay filme;
	JogoEletronico jogoEletronico;
	JogoDeTabuleiro jogoDeTabuleiro;	

	@Before
	public void setUp() throws Exception {
		filme = new BluRayFilme("Quebrando Regras", 5.99, 140, "QUATORZE_ANOS", "Acao", 2008);
		jogoEletronico = new JogoEletronico("ScoreHero", 0.50, "Celular");
		jogoDeTabuleiro = new JogoDeTabuleiro("Xadrez", 50.00);
	}

	@Test
	public void testGetNome() {
		assertEquals(filme.getNome(), "Quebrando Regras");
		assertEquals(jogoEletronico.getNome(), "ScoreHero");
		assertEquals(jogoDeTabuleiro.getNome(), "Xadrez");
	}
	
	@Test
	public void testGetValor() {
		assertEquals(filme.getValor(), 5.99, 5.9);
		assertEquals(jogoEletronico.getValor(), 0.80, 0.8);
		assertEquals(jogoDeTabuleiro.getValor(), 30.00, 30.0);
	}
	
	@Test
	public void testGetNumeroDeEmprestimos() {
		assertEquals(0, filme.getNumeroDeEmprestimos());
	}
}