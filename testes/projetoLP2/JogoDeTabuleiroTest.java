package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.JogoDeTabuleiro;

public class JogoDeTabuleiroTest {
	
	JogoDeTabuleiro war;
	JogoDeTabuleiro black;
	JogoDeTabuleiro monopoly;
	JogoDeTabuleiro dcuba;

	@Before
	public void setUp() throws Exception {
		war = new JogoDeTabuleiro("War", 100);
		black = new JogoDeTabuleiro("Black Stories 2", 50);
		monopoly = new JogoDeTabuleiro("Monopoly", 200);
		dcuba = new JogoDeTabuleiro("Mafia DCuba", 180);
		dcuba.adicionaPecaPerdida("Ficha Capanga");
		black.adicionaPecaPerdida("Carta");
	}

	@Test
	public void testToString() {
		assertEquals("JOGO DE TABULEIRO: War, R$ 100.0, Nao emprestado, COMPLETO", war.toString());
		assertEquals("JOGO DE TABULEIRO: Black Stories 2, R$ 50.0, Nao emprestado, COM PECAS PERDIDAS", black.toString());
		assertEquals("JOGO DE TABULEIRO: Monopoly, R$ 200.0, Nao emprestado, COMPLETO", monopoly.toString());
		assertEquals("JOGO DE TABULEIRO: Mafia DCuba, R$ 180.0, Nao emprestado, COM PECAS PERDIDAS", dcuba.toString());
	}

}