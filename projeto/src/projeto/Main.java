package projeto;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) {
		args = new String[] { "projeto.Fachada", "projeto/acceptance_test/us1_test.txt",
				"projeto/acceptance_test/us2_test.txt", "projeto/acceptance_test/us3_test.txt",
				"projeto/acceptance_test/us4_test.txt", "projeto/acceptance_test/us5_test.txt",
				"projeto/acceptance_test/us6_test.txt", "projeto/acceptance_test/us7_test.txt",
				"projeto/acceptance_test/us8_test.txt" };
		EasyAccept.main(args);
	}
}
	

