package it.uniroma3.diadia.ambienti;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	Stanza s1 = new Stanza("s1");
	Stanza s2= new Stanza("s2");
	Attrezzo m = new Attrezzo("martello", 42);
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente(Direzione.sud));
	}


	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		assertEquals(s2, s1.getStanzaAdiacente(Direzione.sud));
	}

	@Test
	public void testAddAttrezzo() {

		assertTrue(s1.addAttrezzo(m));
	}

}
