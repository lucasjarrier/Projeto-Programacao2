package projetoLP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogos.JogoEletronico;

public class JogoEletronicoTest {

	JogoEletronico blackops2;
	JogoEletronico shadow;
	JogoEletronico burnout;
	JogoEletronico farcry;

	@Before
	public void setUp() throws Exception {
		blackops2 = new JogoEletronico("Call of Duty: Black Ops II", 99.99, "PC");
		shadow = new JogoEletronico("Shadow of the Colossus", 49.99, "PS2");
		burnout = new JogoEletronico("Burnout 3: Takedown", 9.85, "PS2");
		farcry = new JogoEletronico("FarCry 3", 129.99, "PS3");
	}

	@Test
	public void testToString() {
		assertEquals("JOGO ELETRONICO: Call of Duty: Black Ops II, R$ 99.99, Nao emprestado, PC", blackops2.toString());
		assertEquals("JOGO ELETRONICO: Shadow of the Colossus, R$ 49.99, Nao emprestado, PS2", shadow.toString());
		assertEquals("JOGO ELETRONICO: Burnout 3: Takedown, R$ 9.85, Nao emprestado, PS2", burnout.toString());
		assertEquals("JOGO ELETRONICO: FarCry 3, R$ 129.99, Nao emprestado, PS3", farcry.toString());
	}
	
	
}