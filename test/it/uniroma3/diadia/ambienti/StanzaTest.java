package it.uniroma3.diadia.ambienti;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	private Stanza stanza;
	private Attrezzo attrezzo;

	@BeforeEach
	public void setUp() {
		this.stanza = new Stanza("stanza");
		this.attrezzo = new Attrezzo("attrezzo", 1);
	}

	@Test
	void testImpostaStanzaAdiacente() {
		Stanza stanzaAdiacente = new Stanza("stanza adiacente");
		this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		assertEquals(this.stanza.getStanzaAdiacente("nord"), stanzaAdiacente);
	}

	@Test
	void testImpostaCambiaStanzaAdiacente() {
		Stanza stanzaAdiacente = new Stanza("stanza adiacente");
		this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		Stanza nuovaStanzaAdiacente = new Stanza("nuova stanza adiacente");
		this.stanza.impostaStanzaAdiacente("nord", nuovaStanzaAdiacente);
		assertEquals(this.stanza.getStanzaAdiacente("nord"), nuovaStanzaAdiacente);
		assertNotEquals(this.stanza.getStanzaAdiacente("nord"), stanzaAdiacente);
	}

	@Test
	void testImportaMassimo4Stanze() {
		Stanza stanzaAdiacente = new Stanza("adiacente");
		this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		String[] direzioni = {"nord", "sud", "est", "ovest"};
		for(String direzione : direzioni)
			this.stanza.impostaStanzaAdiacente(direzione, stanzaAdiacente);

		String nuovaDirezione = "nord-ovest";
		Stanza stanzaInPiu = new Stanza("stanzaInPiu");
		this.stanza.impostaStanzaAdiacente(nuovaDirezione, stanzaInPiu);
		assertNotEquals(stanzaInPiu, this.stanza.getStanzaAdiacente(nuovaDirezione));
	}

	@Test
	void testStanzaAdiacenteInesistente() {
		assertNull(this.stanza.getStanzaAdiacente("nord"));
	}

	@Test
	void testGetQuattroDirezioni() {
		Stanza salone = new Stanza("salone");
		Stanza cucina = new Stanza("cucina");
		Stanza camera = new Stanza("camera");
		Stanza bagno = new Stanza("bagno");

		this.stanza.impostaStanzaAdiacente("nord", salone);
		this.stanza.impostaStanzaAdiacente("sud", cucina);
		this.stanza.impostaStanzaAdiacente("est", camera);
		this.stanza.impostaStanzaAdiacente("ovest", bagno);

		assertEquals(salone, this.stanza.getStanzaAdiacente("nord"));
		assertEquals(cucina, this.stanza.getStanzaAdiacente("sud"));
		assertEquals(camera, this.stanza.getStanzaAdiacente("est"));
		assertEquals(bagno, this.stanza.getStanzaAdiacente("ovest"));
	}

	@Test
	void testAddAttrezzoRitornaTrue() {
		assertTrue(this.stanza.addAttrezzo(this.attrezzo));
	}

	@Test
	void testAddSingoloAttrezzo() {
		this.stanza.addAttrezzo(this.attrezzo);
		assertEquals(this.stanza.getAttrezzo("attrezzo"), this.attrezzo);
	}

	@Test
	void testHasAttrezzoNonTrovato() {
		assertFalse(this.stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testHasAttrezzoTrovato() {
		this.stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testGetAttrezzo() {
		this.stanza.addAttrezzo(attrezzo);
		assertSame(attrezzo, this.stanza.getAttrezzo("attrezzo"));
	}

	@Test
	void testRemoveAttrezzo() {
		this.stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.removeAttrezzo("attrezzo"));

	}

	@Test
	void testGetDirezioni() {

	}
}
