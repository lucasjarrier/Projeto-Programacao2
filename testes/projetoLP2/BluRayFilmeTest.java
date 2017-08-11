package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bluray.BluRayFilme;

public class BluRayFilmeTest {

	BluRayFilme acao;
	BluRayFilme comedia;
	BluRayFilme terror;
	BluRayFilme suspense;
	
	@Before
	public void setUp() throws Exception {
		acao = new BluRayFilme("Quebrando Regras", 5.99, 140, "QUATORZE_ANOS", "Acao", 2008);
		comedia = new BluRayFilme("Todo mundo em panico: 4", 5.99, 135, "DOZE_ANOS", "Comedia", 2009);
		terror = new BluRayFilme("A volta dos que nao foram", 7.49, 200, "DEZOITO_ANOS", "Terror", 1956);
		suspense = new BluRayFilme("Poeira em alto mar", 10.59, 186, "DEZESSEIS_ANOS", "Suspense", 1985);
	}


	@Test
	public void testToString() {
		assertEquals("FILME: Quebrando Regras, R$ 5.99, Nao emprestado, 140 min, QUATORZE_ANOS, Acao, 2008", acao.toString());
		assertEquals("FILME: Todo mundo em panico: 4, R$ 5.99, Nao emprestado, 135 min, DOZE_ANOS, Comedia, 2009", comedia.toString());
		assertEquals("FILME: A volta dos que nao foram, R$ 7.49, Nao emprestado, 200 min, DEZOITO_ANOS, Terror, 1956", terror.toString());
		assertEquals("FILME: Poeira em alto mar, R$ 10.59, Nao emprestado, 186 min, DEZESSEIS_ANOS, Suspense, 1985", suspense.toString());
	}

}