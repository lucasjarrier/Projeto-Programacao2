package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.BluRaySerie;

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
	public void testGetDescricao() {
		
		assertEquals("O arqueiro verde!", arrow.getDescricao());
		assertEquals("A quimica do mal", bb.getDescricao());
		assertEquals("A melhor serie do mundo!", soa.getDescricao());
	}
	
	@Test
	public void testGetGenero() {
		assertEquals("Acao", arrow.getGenero());
		assertEquals("Drama", bb.getGenero());
		assertEquals("Drama/Acao", soa.getGenero());
	}
	
	@Test
	public void testGetTemporada() {
		assertEquals(1, arrow.getTemporada());
		assertEquals(2, bb.getTemporada());
		assertEquals(7, soa.getTemporada());
	}
	
	@Test
	public void testToString() {
		assertEquals("SERIE: Arrow, R$ 39.99, Nao emprestado, 450 min, Acao, QUATORZE_ANOS, Temporada 1", arrow.toString());
		assertEquals("SERIE: Breaking Bad, R$ 88.99, Nao emprestado, 378 min, Drama, DEZESSEIS_ANOS, Temporada 2", bb.toString());
		assertEquals("SERIE: Sons of Anarchy, R$ 129.99, Nao emprestado, 475 min, Drama/Acao, DEZESSEIS_ANOS, Temporada 7", soa.toString());
	}
	
	@Test
	public void testAdicionaEpisodio() {
		arrow.adicionaEpisodio(20);
		bb.adicionaEpisodio(50);
		soa.adicionaEpisodio(45);
	}
	
}