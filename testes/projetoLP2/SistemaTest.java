package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.Sistema;

public class SistemaTest {

	Sistema sistema;

	@Before
	public void setUp() throws Exception {

		sistema = new Sistema();

		/*
		 * CRIANDO USUARIOS.
		 */

		sistema.cadastrarUsuario("Jarrier", "98888-8888", "lucas@gmail.com");
		sistema.cadastrarUsuario("Higor", "97777-7777", "higor@yahoo.com");
		sistema.cadastrarUsuario("Thallyson", "96666-6666", "teles@bol.com");
		sistema.cadastrarUsuario("Daniel", "95555-5555", "daniel@hotmail.com");

		/*
		 * CADASTRANDO ITENS EM USUARIOS.
		 */

		sistema.cadastraJogoTabuleiro("Higor", "97777-7777", "War", 29.00);
		sistema.cadastraEletronico("Higor", "97777-7777", "Batman", 85.00, "PS4");
		sistema.cadastraFilme("Higor", "97777-7777", "Xuxa", 12.00, 150, "Musical", "LIVRE", 2000);

		sistema.cadastraJogoTabuleiro("Jarrier", "98888-8888", "Poker", 300.20);
		sistema.cadastraEletronico("Jarrier", "98888-8888", "CSGO", 29.90, "PC");
		sistema.cadastraShow("Jarrier", "98888-8888", "CHEGOU VERAO", 3.99, 100, 11, "Wesley", "DEZ_ANOS");

		sistema.cadastraEletronico("Daniel", "95555-5555", "GTA", 60.00, "XONE");
		sistema.cadastraFilme("Daniel", "95555-5555", "Avengers", 11.00, 130, "Acao", "DEZ_ANOS", 2010);
		sistema.cadastraSerie("Daniel", "95555-5555", "GOT", 500, "STARKS", 730, "Ficção", "DEZOITO_ANOS", 7);

		sistema.cadastraFilme("Thallyson", "96666-6666", "Cinderela", 10.50, 50, "Animacao", "LIVRE", 1990);
		sistema.cadastraFilme("Thallyson", "96666-6666", "Peter-Pan", 11.20, 99, "Animacao", "LIVRE", 2007);
		sistema.cadastraFilme("Thallyson", "96666-6666", "PeppaPig", 9.99, 69, "Animacao", "LIVRE", 2017);

	}
	
	@Test 
	public void testGetInfoItem() throws Exception {
		assertEquals(sistema.getInfoItem("Higor", "97777-7777", "War", "Nome"), "War");
		assertEquals(sistema.getInfoItem("Jarrier", "98888-8888", "Poker", "Preco"), "300.2");
		assertEquals(sistema.getInfoItem("Daniel", "95555-5555", "GOT", "Nome"), "GOT");
		assertEquals(sistema.getInfoItem("Thallyson", "96666-6666", "Peter-Pan", "Preco"), "11.2");
	}

}
