package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bluray.BluRayShow;

public class BluRayShowTest {

	BluRayShow gilbala;
	BluRayShow aldairplayboy;
	BluRayShow forropegado;
	BluRayShow canacommel;

	@Before
	public void setUp() throws Exception {
		gilbala = new BluRayShow("O Rei do Batidao", 10.99, 65, "LIVRE", "Gil Bala", 15);
		aldairplayboy = new BluRayShow("Aldair Playboy: So elite!", 10.99, 70, "LIVRE", "Aldair Playboy", 15);
		forropegado = new BluRayShow("Forro Pegado: So nos paredao", 15.49, 70, "LIVRE", "Forro Pegado", 20);
		canacommel = new BluRayShow("Forro Cana com Mel: Eh bem docin, papai!", 20.99, 80, "LIVRE", "Cana com Mel", 18);
	}

	

	@Test
	public void testToString() {
		assertEquals("SHOW: O Rei do Batidao, R$ 10.99, Nao emprestado, 65 min, LIVRE, Gil Bala, 15 faixas", gilbala.toString());
		assertEquals("SHOW: Aldair Playboy: So elite!, R$ 10.99, Nao emprestado, 70 min, LIVRE, Aldair Playboy, 15 faixas", aldairplayboy.toString());
		assertEquals("SHOW: Forro Pegado: So nos paredao, R$ 15.49, Nao emprestado, 70 min, LIVRE, Forro Pegado, 20 faixas", forropegado.toString());
		assertEquals("SHOW: Forro Cana com Mel: Eh bem docin, papai!, R$ 20.99, Nao emprestado, 80 min, LIVRE, Cana com Mel, 18 faixas", canacommel.toString());
	}

}
