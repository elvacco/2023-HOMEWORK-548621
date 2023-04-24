package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private StanzaBuia stanza;

	@BeforeEach
	public void setUp() {
		this.stanza = new StanzaBuia("stanza", "lanterna");
	}

	@Test
	public void testLanternaNonPresente() {
		assertEquals(this.stanza.getDescrizione(), "Qui c'e' buio pesto");
	}

	@Test
	public void testLanternaPresente() {
		Attrezzo attrezzo = new Attrezzo("lanterna", 1); 
		this.stanza.addAttrezzo(attrezzo);

		assertNotEquals(this.stanza.getDescrizione(), "Qui c'Ë buio pesto\n");
	}
}
