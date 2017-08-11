package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bluray.BluRaySerie;

public class BluRaySerieTest {

	BluRaySerie arrow;
	BluRaySerie bb;
	BluRaySerie soa;
	
	@Before
	public void setUp() throws Exception {
		arrow = new BluRaySerie("Arrow", 39.99, 450, "QUATORZE_ANOS", "O arqueiro verde!", "Acao", 1);
		bb = new BluRaySerie("Breaking Bad", 88.99, 378, "DEZESSEIS_ANOS", "A quimica do mal", "Drama", 2);
		soa = new BluRaySerie("Sons of Anarchy", 129.99, 475, "DEZESSEIS_ANOS", "A melhor serie do mundo!", "Drama/Acao", 7);
	}
	
	@Test
	public void testToString() {
		assertEquals("SERIE: Arrow, R$ 39.99, Nao emprestado, 450 min, Acao, QUATORZE_ANOS, Temporada 1", arrow.toString());
		assertEquals("SERIE: Breaking Bad, R$ 88.99, Nao emprestado, 378 min, Drama, DEZESSEIS_ANOS, Temporada 2", bb.toString());
		assertEquals("SERIE: Sons of Anarchy, R$ 129.99, Nao emprestado, 475 min, Drama/Acao, DEZESSEIS_ANOS, Temporada 7", soa.toString());
	}
	
}