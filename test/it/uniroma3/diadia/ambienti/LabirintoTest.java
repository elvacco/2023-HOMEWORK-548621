package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
	}

	@Test
	void testCreaStanze() {
		assertEquals(this.labirinto.getStanzaIniziale().getNome(), "Atrio");
		assertEquals(this.labirinto.getStanzaFinale().getNome(), "Biblioteca");
		assertEquals(this.labirinto.getStanzaIniziale().getStanzaAdiacente("nord").getNome(), "Biblioteca");
		assertEquals(this.labirinto.getStanzaIniziale().getStanzaAdiacente("sud").getNome(), "Aula N10");
		assertEquals(this.labirinto.getStanzaIniziale().getStanzaAdiacente("est").getNome(), "Aula N11");
		assertEquals(this.labirinto.getStanzaIniziale().getStanzaAdiacente("ovest").getNome(), "Laboratorio Campus");
		assertEquals(this.labirinto.getStanzaFinale().getStanzaAdiacente("sud").getNome(), "Atrio");
		assertTrue(this.labirinto.getStanzaIniziale().hasAttrezzo("osso"));
	}

}
