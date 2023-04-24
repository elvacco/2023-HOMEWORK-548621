package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private StanzaBloccata stanza;

	@BeforeEach
	public void setUp() {
		this.stanza = new StanzaBloccata("stanza", "pidediporco", "nord");
	}

	@Test
	public void testStanzaBloccata() {
		assertEquals(this.stanza.getDescrizione(), "Direzione bloccata\n");
	}


	@Test
	public void testStanzaSbloccata() {
		Attrezzo attrezzo = new Attrezzo("piedediporco", 1);
		this.stanza.addAttrezzo(attrezzo);

		assertEquals(this.stanza.getDescrizione(), "Direzione bloccata\n");
	}
}
