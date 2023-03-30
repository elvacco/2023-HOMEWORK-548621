package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {

	static final private int CFU_INIZIALI = 20;
	private Giocatore giocatore;

	@BeforeEach
	public void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testCfuNonFinitiInizioParitita() {
		assertNotEquals(this.giocatore.getCfu(), 0);
	}

	@Test
	public void testCfuIniziali() {
		assertEquals(CFU_INIZIALI, this.giocatore.getCfu());
	}

}
