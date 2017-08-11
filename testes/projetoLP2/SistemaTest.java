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
	public void testCadastrarUsuario() {
		sistema.cadastrarUsuario("Kleberson", "2424-1111","kleberson123@gmail.com.br");
		sistema.cadastrarUsuario("Apodi", "8787-9898","apodi_mito@gmail.com");
		sistema.cadastrarUsuario("Keirrison", "8888-8888", "keirrison_barcelona@yahoo.com.br");
		sistema.cadastrarUsuario("Paulo Baier", "9999-9999","baier.paulo@hotmail.com");
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetInfoUsuario() {
		assertEquals(sistema.getInfoUsuario("Kleberson","2424-1111","Email"), "kleberson123@gmail.com.br");
		assertEquals(sistema.getInfoUsuario("Apodi","8787-9898","Telefone"), "8787-9898");
		assertEquals(sistema.getInfoUsuario("Keirrison","8888-8888","Nome"), "Keirrison");
		assertEquals(sistema.getInfoUsuario("Paulo Baier", "9999-9999", "Email"), "baier.paulo@hotmail.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoverUsuario() {
		sistema.removerUsuario("Kleberson", "2424-1111");
		assertEquals("Usuario Invalido", sistema.getInfoUsuario("Kleberson","2424-1111","Email"));
		sistema.removerUsuario("Apodi", "8787-9898");
		assertEquals("Usuario Invalido", sistema.getInfoUsuario("Apodi","8787-9898","Telefone"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizarUsuario() {
		sistema.atualizarUsuario("Keirrison", "8888-8888", "Email", "keirrison_coritiba@yahoo.com.br");
		assertEquals("keirrison_coritiba@yahoo.com.br", sistema.getInfoUsuario("Keirrison", "8888-8888", "Email"));
		sistema.atualizarUsuario("Paulo Baier", "9999-9999", "Telefone", "0000-0000");
		assertEquals("0000-0000", sistema.getInfoUsuario("Paulo Baier", "0000-0000", "Telefone"));
	}
	

	@Test
	public void testPesquisarDetalhesItens() throws Exception {
		assertEquals(sistema.pesquisarDetalhesItem("Jarrier", "98888-8888", "CSGO"),
				"JOGO ELETRONICO: CSGO, R$ 29.9, Nao emprestado, PC");
		assertEquals(sistema.pesquisarDetalhesItem("Higor", "97777-7777", "War"),
				"JOGO DE TABULEIRO: War, R$ 29.0, Nao emprestado, COMPLETO");
		assertEquals(sistema.pesquisarDetalhesItem("Daniel", "95555-5555", "Avengers"),
				"FILME: Avengers, R$ 11.0, Nao emprestado, 130 min, DEZ_ANOS, Acao, 2010");
		assertEquals(sistema.pesquisarDetalhesItem("Thallyson", "96666-6666", "Cinderela"),
				"FILME: Cinderela, R$ 10.5, Nao emprestado, 50 min, LIVRE, Animacao, 1990");
	}

	@Test(expected = NullPointerException.class)
	public void testPesquisarDetalhesItensInvalidos() throws Exception {
		sistema.pesquisarDetalhesItem("", "98888-8888", "CSGO");
		sistema.pesquisarDetalhesItem("Higor", "", "Xuxa");
		sistema.pesquisarDetalhesItem("Thallyson", "96666-6666", null);
		sistema.pesquisarDetalhesItem(null, null, null);
	}

	@Test
	public void testeListarItensOrdenadosNome() {
		assertEquals(sistema.listarItensOrdenadosPorNome(),
				"FILME: Avengers, R$ 11.0, Nao emprestado, 130 min, DEZ_ANOS, Acao, 2010|JOGO ELETRONICO: Batman, R$ 85.0, Nao emprestado, PS4|SHOW: CHEGOU VERAO, R$ 3.99, Nao emprestado, 100 min, DEZ_ANOS, Wesley, 11 faixas|JOGO ELETRONICO: CSGO, R$ 29.9, Nao emprestado, PC|FILME: Cinderela, R$ 10.5, Nao emprestado, 50 min, LIVRE, Animacao, 1990|SERIE: GOT, R$ 500.0, Nao emprestado, 730 min, Ficção, DEZOITO_ANOS, Temporada 7|JOGO ELETRONICO: GTA, R$ 60.0, Nao emprestado, XONE|FILME: PeppaPig, R$ 9.99, Nao emprestado, 69 min, LIVRE, Animacao, 2017|FILME: Peter-Pan, R$ 11.2, Nao emprestado, 99 min, LIVRE, Animacao, 2007|JOGO DE TABULEIRO: Poker, R$ 300.2, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: War, R$ 29.0, Nao emprestado, COMPLETO|FILME: Xuxa, R$ 12.0, Nao emprestado, 150 min, LIVRE, Musical, 2000|");
	}

	@Test
	public void testeListarItensOrdenadosValor() {
		assertEquals(sistema.listarItensOrdenadosPorValor(),
				"SHOW: CHEGOU VERAO, R$ 3.99, Nao emprestado, 100 min, DEZ_ANOS, Wesley, 11 faixas|FILME: PeppaPig, R$ 9.99, Nao emprestado, 69 min, LIVRE, Animacao, 2017|FILME: Cinderela, R$ 10.5, Nao emprestado, 50 min, LIVRE, Animacao, 1990|FILME: Avengers, R$ 11.0, Nao emprestado, 130 min, DEZ_ANOS, Acao, 2010|FILME: Peter-Pan, R$ 11.2, Nao emprestado, 99 min, LIVRE, Animacao, 2007|FILME: Xuxa, R$ 12.0, Nao emprestado, 150 min, LIVRE, Musical, 2000|JOGO DE TABULEIRO: War, R$ 29.0, Nao emprestado, COMPLETO|JOGO ELETRONICO: CSGO, R$ 29.9, Nao emprestado, PC|JOGO ELETRONICO: GTA, R$ 60.0, Nao emprestado, XONE|JOGO ELETRONICO: Batman, R$ 85.0, Nao emprestado, PS4|JOGO DE TABULEIRO: Poker, R$ 300.2, Nao emprestado, COMPLETO|SERIE: GOT, R$ 500.0, Nao emprestado, 730 min, Ficção, DEZOITO_ANOS, Temporada 7|");
	}
}
