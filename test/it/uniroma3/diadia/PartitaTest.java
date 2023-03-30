package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {
	
	private Partita partita;
	
	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
	}

	@Test
	void testVintaStanzaCorrenteNonVincente() {
		assertNotEquals(this.partita.getStanzaCorrente(), this.partita.getStanzaVincente());
		assertFalse(this.partita.vinta());
	}
	
	@Test
	void testVintaStanzaCorrenteUgualeStanzaVincente() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertEquals(this.partita.getStanzaCorrente(), this.partita.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	void testIsFinitaPartitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertEquals(this.partita.isFinita(), this.partita.vinta());
	}
	
	@Test
	void testIsFinitaTramitaComando() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testIsFinita0Cfu() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}

}
