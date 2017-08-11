package projetoLP2;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

public class UsuarioTest {

	Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;

	@Before
	public void setUp() throws Exception {

		usuario1 = new Usuario("Yoda", "9898-9898", "fon_hi@hotmail.com");
		usuario2 = new Usuario("Brtt", "2122-2324", "rexpeita@gmail.com");
		usuario3 = new Usuario("Hastad", "5555-5555", "cabalo123@yahoo.com.br");
	}

	@Test
	public void testToString() {
		assertEquals(usuario1.toString(), "Yoda, fon_hi@hotmail.com, 9898-9898");
		assertEquals(usuario2.toString(), "Brtt, rexpeita@gmail.com, 2122-2324");
		assertEquals(usuario3.toString(), "Hastad, cabalo123@yahoo.com.br, 5555-5555");
	}

	@Test
	public void testGetNome() {
		assertEquals("Yoda", usuario1.getNome());
		assertEquals("Brtt", usuario2.getNome());
		assertEquals("Hastad", usuario3.getNome());
	}

	@Test
	public void testGetEmail() {
		assertEquals("fon_hi@hotmail.com", usuario1.getEmail());
		assertEquals("rexpeita@gmail.com", usuario2.getEmail());
		assertEquals("cabalo123@yahoo.com.br", usuario3.getEmail());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("9898-9898", usuario1.getTelefone());
		assertEquals("2122-2324", usuario2.getTelefone());
		assertEquals("5555-5555", usuario3.getTelefone());
	}

	@Test
	public void testSetNome() {
		assertEquals("Yoda", usuario1.getNome());
		usuario1.setNome("Aline Faria");
		assertEquals("Aline Faria", usuario1.getNome());
	}

	@Test
	public void testSetEmail() {
		assertEquals("rexpeita@gmail.com", usuario2.getEmail());
		usuario2.setEmail("oque_que_houve@gmail.com");
		assertEquals("oque_que_houve@gmail.com", usuario2.getEmail());
	}

	@Test
	public void testSetTelefone() {
		assertEquals("5555-5555", usuario3.getTelefone());
		usuario3.setTelefone("3333-3333");
		assertEquals("3333-3333", usuario3.getTelefone());
	}

	@Test
	public void testAdicionaFilme() throws Exception {

		usuario3.adicionaFilme("Titanic", 2.50, 3, "14 anos", "DRAMA", 1912);
	}

	@Test
	public void testAdicionaShow() throws Exception {

		usuario2.adicionaShow("WS In Miami", 1.99, 2, "12 anos",
				"Wesley Safadão", 38);
	}

	public void testAdicionaSerie() throws Exception {
		usuario1.adicionaSerie("Zoo", 1.30, 50, "16 anos", "Boa serie",
				"Apocalipse", 3);
	}

	public void testAdicionaEletronico() throws Exception {
		usuario1.adicionaEletronico("CS:GO", 30, "PC");
		usuario2.adicionaEletronico("Habbo", 0, "PC");
		usuario3.adicionaEletronico("FIFA", 150, "PlayStation");
	}

	public void testAdicionaTabuleiro() throws Exception {
		usuario1.adicionaTabuleiro("WAR", 65);
		usuario3.adicionaTabuleiro("Dama", 0);
	}

	public void testAdicionaBluRay() throws Exception {
		usuario1.adicionaBluRay("A volta dos que nao foram", 50);
	}

	@Test
	public void testGetItem() throws Exception {
		usuario1.adicionaEletronico("Mortal Kombat", 10, "PS2");
		assertEquals("[JOGO ELETRONICO: Mortal Kombat, R$ 10.0, Nao emprestado, PS2]", usuario1.getItens().toString());
	}

	@Test
	public void testAdicionaPecaPerdida() throws Exception {
		usuario2.adicionaTabuleiro("Xadrez", 1);
		assertEquals("[JOGO DE TABULEIRO: Xadrez, R$ 1.0, Nao emprestado, COMPLETO]", usuario2.getItens().toString());
		usuario2.adicionaPecaPerdida("Xadrez", "Rei");
		assertEquals("[JOGO DE TABULEIRO: Xadrez, R$ 1.0, Nao emprestado, COM PECAS PERDIDAS]",	usuario2.getItens().toString());
	}

	@Test
	public void testRemoveItem() throws Exception {
		usuario3.adicionaFilme("Logan", 500, 200, "18 anos", "DRAMA, ACAO",	2017);
		assertEquals("[FILME: Logan, R$ 500.0, Nao emprestado, 200 min, 18 anos, DRAMA, ACAO, 2017]", usuario3.getItens().toString());
		usuario3.removeItem("Logan");
		assertEquals("[]", usuario3.getItens().toString());
	}

	@Test
	public void testExibirItens() throws Exception {
		usuario1.adicionaEletronico("League Of Legends", 1, "PC");
		assertEquals("JOGO ELETRONICO: League Of Legends, R$ 1.0, Nao emprestado, PC", usuario1.exibirItens().toString());
	}
}
