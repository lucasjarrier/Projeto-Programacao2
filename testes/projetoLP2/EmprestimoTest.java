package projetoLP2;

import org.junit.Before;
import org.junit.Test;

import projeto.Sistema;

public class EmprestimoTest {

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

		/*
		 * REGISTRANDO EMPRESTIMOS ENTRE USUARIOS.
		 */

		sistema.registrarEmprestimo("Thallyson", "96666-6666", "Jarrier", "98888-8888", "Cinderela", "15/08/2017", 45);
		sistema.registrarEmprestimo("Daniel", "95555-5555", "Jarrier", "98888-8888", "GTA", "12/08/2017", 15);
		sistema.registrarEmprestimo("Jarrier", "98888-8888", "Thallyson", "96666-6666", "CSGO", "13/08/2017", 13);

	}

	@Test(expected = NullPointerException.class)
	public void testaRegistroEmprestimoDeUsuarioInvalido() throws Exception {
		sistema.registrarEmprestimo("Thales", "96666-6666", "Jarrier", "98888-8888", "Cinderela", "15/08/2017", 45);
		sistema.registrarEmprestimo("Bales", "96666-6666", "Jarrier", "98888-8888", "Cinderela", "15/08/2017", 45);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testaRegistroEmprestimoExistente() throws Exception {
		sistema.registrarEmprestimo("Thallyson", "96666-6666", "Jarrier", "98888-8888", "Cinderela", "15/08/2017", 45);
		sistema.registrarEmprestimo("Thallyson", "96666-6666", "Jarrier", "98888-8888", "Cinderela", "15/08/2017", 45);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testaIteEmpretado() throws Exception {
		sistema.registrarEmprestimo("Daniel", "95555-5555", "Thallyson", "96666-6666", "GTA", "15/08/2017", 45);
		sistema.registrarEmprestimo("Thallyson", "96666-6666", "Jarrier", "98888-8888", "CSGO", "15/08/2017", 45);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testaItemNaoExistente() throws Exception{
		sistema.registrarEmprestimo("Daniel", "95555-5555", "Thallyson", "96666-6666", "TOMB RAIDER", "15/08/2017", 45);
		sistema.registrarEmprestimo("Thallyson", "96666-6666", "Jarrier", "98888-8888", "CS 1.6", "15/08/2017", 45);
	}
	
	
}
