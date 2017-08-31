package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.Item;
import projeto.EmprestimoController;
import projeto.UsuarioController;
import usuario.Usuario;
import usuario.UsuarioID;

public class SistemaTest {

	UsuarioController sistema;
	EmprestimoController emprestimo;

	@Before
	public void setUp() throws Exception {

		sistema = new UsuarioController();
		emprestimo = new EmprestimoController();

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

		/*
		 * PEGANDO ITENS EMPRESTADOS.
		 */

		sistema.registrarEmprestimo("Thallyson", "96666-6666", "Higor", "97777-7777", "Cinderela", "25/08/2017", 7);
		sistema.registrarEmprestimo("Thallyson", "96666-6666", "Jarrier", "98888-8888", "PeppaPig", "25/08/2017", 7);
		sistema.registrarEmprestimo("Jarrier", "98888-8888", "Thallyson", "96666-6666", "CSGO", "25/08/2017", 7);
		sistema.registrarEmprestimo("Jarrier", "98888-8888", "Daniel", "95555-5555", "Poker", "01/09/2017", 7);
		sistema.registrarEmprestimo("Daniel", "95555-5555", "Thallyson", "96666-6666", "GOT", "05/09/2017", 7);
		sistema.registrarEmprestimo("Higor", "97777-7777", "Thallyson", "96666-6666", "Xuxa", "06/09/2017", 7);

		/*
		 * DEVOLVER ITENS EMPRESTADOS.
		 */

		sistema.devolverItem("Thallyson", "96666-6666", "Higor", "97777-7777", "Cinderela", "25/08/2017", "31/09/2017");
		sistema.devolverItem("Thallyson", "96666-6666", "Jarrier", "98888-8888", "PeppaPig", "25/08/2017",
				"29/08/2017");
		sistema.devolverItem("Jarrier", "98888-8888", "Thallyson", "96666-6666", "CSGO", "25/08/2017", "20/10/2018");
		sistema.devolverItem("Jarrier", "98888-8888", "Daniel", "95555-5555", "Poker", "25/08/2017", "28/08/2017");

	}

	@Test
	public void testCadastrarUsuario() {
		sistema.cadastrarUsuario("Kleberson", "2424-1111", "kleberson123@gmail.com.br");
		sistema.cadastrarUsuario("Apodi", "8787-9898", "apodi_mito@gmail.com");
		sistema.cadastrarUsuario("Keirrison", "8888-8888", "keirrison_barcelona@yahoo.com.br");
		sistema.cadastrarUsuario("Paulo Baier", "9999-9999", "baier.paulo@hotmail.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuario() {
		assertEquals(sistema.getInfoUsuario("Kleberson", "2424-1111", "Email"), "kleberson123@gmail.com.br");
		assertEquals(sistema.getInfoUsuario("Apodi", "8787-9898", "Telefone"), "8787-9898");
		assertEquals(sistema.getInfoUsuario("Keirrison", "8888-8888", "Nome"), "Keirrison");
		assertEquals(sistema.getInfoUsuario("Paulo Baier", "9999-9999", "Email"), "baier.paulo@hotmail.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoverUsuario() {
		sistema.removerUsuario("Kleberson", "2424-1111");
		assertEquals("Usuario Invalido", sistema.getInfoUsuario("Kleberson", "2424-1111", "Email"));
		sistema.removerUsuario("Apodi", "8787-9898");
		assertEquals("Usuario Invalido", sistema.getInfoUsuario("Apodi", "8787-9898", "Telefone"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizarUsuario() {
		sistema.atualizarUsuario("Keirrison", "8888-8888", "Email", "keirrison_coritiba@yahoo.com.br");
		assertEquals("keirrison_coritiba@yahoo.com.br", sistema.getInfoUsuario("Keirrison", "8888-8888", "Email"));
		sistema.atualizarUsuario("Paulo Baier", "9999-9999", "Telefone", "0000-0000");
		assertEquals("0000-0000", sistema.getInfoUsuario("Paulo Baier", "0000-0000", "Telefone"));
	}

	@Test
	public void testGetInfoItem() throws Exception {
		assertEquals(sistema.getInfoItem("Higor", "97777-7777", "War", "Nome"), "War");
		assertEquals(sistema.getInfoItem("Jarrier", "98888-8888", "Poker", "Preco"), "300.2");
		assertEquals(sistema.getInfoItem("Daniel", "95555-5555", "GOT", "Nome"), "GOT");
		assertEquals(sistema.getInfoItem("Thallyson", "96666-6666", "Peter-Pan", "Preco"), "11.2");
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
				"FILME: Avengers, R$ 11.0, Nao emprestado, 130 min, DEZ_ANOS, Acao, 2010|JOGO ELETRONICO: Batman, R$ 85.0, Nao emprestado, PS4|SHOW: CHEGOU VERAO, R$ 3.99, Nao emprestado, 100 min, DEZ_ANOS, Wesley, 11 faixas|JOGO ELETRONICO: CSGO, R$ 29.9, Nao emprestado, PC|FILME: Cinderela, R$ 10.5, Nao emprestado, 50 min, LIVRE, Animacao, 1990|SERIE: GOT, R$ 500.0, Emprestado, 730 min, Ficção, DEZOITO_ANOS, Temporada 7|JOGO ELETRONICO: GTA, R$ 60.0, Nao emprestado, XONE|FILME: PeppaPig, R$ 9.99, Nao emprestado, 69 min, LIVRE, Animacao, 2017|FILME: Peter-Pan, R$ 11.2, Nao emprestado, 99 min, LIVRE, Animacao, 2007|JOGO DE TABULEIRO: Poker, R$ 300.2, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: War, R$ 29.0, Nao emprestado, COMPLETO|FILME: Xuxa, R$ 12.0, Emprestado, 150 min, LIVRE, Musical, 2000|");
	}

	@Test
	public void testeListarItensOrdenadosValor() {
		assertEquals(sistema.listarItensOrdenadosPorValor(),
				"SHOW: CHEGOU VERAO, R$ 3.99, Nao emprestado, 100 min, DEZ_ANOS, Wesley, 11 faixas|FILME: PeppaPig, R$ 9.99, Nao emprestado, 69 min, LIVRE, Animacao, 2017|FILME: Cinderela, R$ 10.5, Nao emprestado, 50 min, LIVRE, Animacao, 1990|FILME: Avengers, R$ 11.0, Nao emprestado, 130 min, DEZ_ANOS, Acao, 2010|FILME: Peter-Pan, R$ 11.2, Nao emprestado, 99 min, LIVRE, Animacao, 2007|FILME: Xuxa, R$ 12.0, Emprestado, 150 min, LIVRE, Musical, 2000|JOGO DE TABULEIRO: War, R$ 29.0, Nao emprestado, COMPLETO|JOGO ELETRONICO: CSGO, R$ 29.9, Nao emprestado, PC|JOGO ELETRONICO: GTA, R$ 60.0, Nao emprestado, XONE|JOGO ELETRONICO: Batman, R$ 85.0, Nao emprestado, PS4|JOGO DE TABULEIRO: Poker, R$ 300.2, Nao emprestado, COMPLETO|SERIE: GOT, R$ 500.0, Emprestado, 730 min, Ficção, DEZOITO_ANOS, Temporada 7|");
	}

	@Test
	public void testaPioresUsuarios() {

		assertEquals(sistema.listarTop10PioresUsuarios(),
				"1: Thallyson - Reputacao: -120,15|2: Higor - Reputacao: 4,46|3: Jarrier - Reputacao: 50,21|4: Daniel - Reputacao: 93,56|");
		sistema.cadastraJogoTabuleiro("Thallyson", "96666-6666", "Damas Hiper Raro", 3400.50);
		sistema.cadastraEletronico("Daniel", "95555-5555", "Shadow of Mordor Limited Edition", 250.90, "PC");
		assertEquals(sistema.listarTop10PioresUsuarios(),
				"1: Higor - Reputacao: 4,46|2: Thallyson - Reputacao: 49,87|3: Jarrier - Reputacao: 50,21|4: Daniel - Reputacao: 106,11|");

	}

	@Test
	public void testaMelhoresUsuarios() {
		assertEquals(sistema.listarTop10MelhoresUsuarios(),
				"1: Daniel - Reputacao: 93,56|2: Jarrier - Reputacao: 50,21|3: Higor - Reputacao: 4,46|4: Thallyson - Reputacao: -120,15|");
		sistema.cadastraEletronico("Thallyson", "96666-6666", "Skyrim VII", 3500.00, "PS5");
		assertEquals(sistema.listarTop10MelhoresUsuarios(),
				"1: Daniel - Reputacao: 93,56|2: Thallyson - Reputacao: 54,85|3: Jarrier - Reputacao: 50,21|4: Higor - Reputacao: 4,46|");
	}

	@Test
	public void testaListaCaloteiros() {
		assertEquals(sistema.listarCaloteiros(),
				"Lista de usuarios com reputacao negativa: Thallyson, teles@bol.com, 96666-6666|");
	}

	@Test
	public void testaListaDeItensEmprestados() {
		assertEquals(sistema.listarItensEmprestados(),
				"Dono do item: Daniel, Nome do item emprestado: GOT|Dono do item: Higor, Nome do item emprestado: Xuxa|");

	}

	@Test
	public void testaListaDeItensNaoEmprestados() {
		assertEquals(sistema.listarItensNaoEmprestados(),
				"FILME: Avengers, R$ 11.0, Nao emprestado, 130 min, DEZ_ANOS, Acao, 2010|JOGO ELETRONICO: Batman, R$ 85.0, Nao emprestado, PS4|SHOW: CHEGOU VERAO, R$ 3.99, Nao emprestado, 100 min, DEZ_ANOS, Wesley, 11 faixas|JOGO ELETRONICO: CSGO, R$ 29.9, Nao emprestado, PC|FILME: Cinderela, R$ 10.5, Nao emprestado, 50 min, LIVRE, Animacao, 1990|JOGO ELETRONICO: GTA, R$ 60.0, Nao emprestado, XONE|FILME: PeppaPig, R$ 9.99, Nao emprestado, 69 min, LIVRE, Animacao, 2017|FILME: Peter-Pan, R$ 11.2, Nao emprestado, 99 min, LIVRE, Animacao, 2007|JOGO DE TABULEIRO: Poker, R$ 300.2, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: War, R$ 29.0, Nao emprestado, COMPLETO|");
	}

	@Test
	public void testaTop10Itens() {
		assertEquals(sistema.listarTop10Itens(),
				"1) 1 emprestimos - FILME: Xuxa, R$ 12.0, Emprestado, 150 min, LIVRE, Musical, 2000|2) 1 emprestimos - SERIE: GOT, R$ 500.0, Emprestado, 730 min, Ficção, DEZOITO_ANOS, Temporada 7|3) 1 emprestimos - FILME: Cinderela, R$ 10.5, Nao emprestado, 50 min, LIVRE, Animacao, 1990|4) 1 emprestimos - FILME: PeppaPig, R$ 9.99, Nao emprestado, 69 min, LIVRE, Animacao, 2017|5) 1 emprestimos - JOGO DE TABULEIRO: Poker, R$ 300.2, Nao emprestado, COMPLETO|6) 1 emprestimos - JOGO ELETRONICO: CSGO, R$ 29.9, Nao emprestado, PC|");
	}
	
}
