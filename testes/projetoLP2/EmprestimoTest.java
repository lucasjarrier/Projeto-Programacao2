package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;
import emprestimo.Emprestimo;
import item.JogoDeTabuleiro;

public class EmprestimoTest {

	Usuario sirano;
	Usuario sirino;
	Emprestimo emprestar;
	Emprestimo emprestar2;
	JogoDeTabuleiro gamao;
	JogoDeTabuleiro xadrez;

	@Before
	public void setUp() throws Exception {

		sirano = new Usuario("Sirano", "998249031", "sirano_56@gmail.com");
		sirino = new Usuario("Sirino", "998829005", "cat_sirino@hotmail.com");
		gamao = new JogoDeTabuleiro("Gamao", 80.00);
		xadrez = new JogoDeTabuleiro("Xadrez", 600.00);
		emprestar = new Emprestimo(sirano, sirino, gamao, 3, "07/01/2017");
		emprestar2 = new Emprestimo(sirino, sirano, xadrez, 3, "07/01/2017");
	}

	@Test
	public void testDevolveItem() {
		emprestar.devolveItem("07/01/2017", "10/01/2017");
		assertEquals(0, emprestar.getDiasDeAtraso());
		emprestar2.devolveItem("07/01/2017", "11/01/2017");
		assertEquals(1, emprestar2.getDiasDeAtraso());
	}

	@Test
	public void testCalculaAtraso() {
		assertEquals(0, 0, sirino.getReputacao());
		emprestar2.devolveItem("07/01/2017", "11/01/2017");
		assertEquals(2.0, sirano.getReputacao(), 0);

		assertEquals(2.0, 0, sirano.getReputacao());
		emprestar.devolveItem("07/01/2017", "09/01/2017");
		assertEquals(64.0, sirino.getReputacao(), 0);
	}

	@Test
	public void testToString() {
		assertEquals("EMPRESTIMO - De: Sirano, Para: Sirino," + " Gamao, 07/01/2017, 3 dias, ENTREGA: "
				+ "Emprestimo em andamento", emprestar.toString());
		assertEquals("EMPRESTIMO - De: Sirino, Para: Sirano," + " Xadrez, 07/01/2017, 3 dias, ENTREGA: "
				+ "Emprestimo em andamento", emprestar2.toString());
	}

	@Test
	public void testEqualsObject() {

		Usuario pele = new Usuario("pele", "33106000", "10efaixa@bol.com");

		Emprestimo emprestar2 = new Emprestimo(sirano, sirino, gamao, 3, "12/12/2005");
		assertEquals(true, emprestar.equals(emprestar2));

		Emprestimo emprestar3 = new Emprestimo(pele, sirino, xadrez, 4, "12/12/2005");
		assertEquals(false, emprestar.equals(emprestar3));

		Emprestimo emprestar4 = new Emprestimo(sirino, pele, gamao, 4, "12/12/2005");
		assertEquals(false, emprestar.equals(emprestar4));

		Emprestimo emprestar5 = new Emprestimo(sirino, sirano, xadrez, 4, "12/12/2005");
		assertEquals(false, emprestar.equals(emprestar5));
	}
}
