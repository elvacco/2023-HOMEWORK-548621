package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Partita partita;
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
		this.stanzaCorrente = labirinto.getStanzaCorrente();
		this.stanzaVincente = labirinto.getStanzaVincente();
		partita = new Partita(this.labirinto); 
	}

	@Test
	public void testVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testNonVinta() {
		this.partita.setStanzaCorrente(stanzaCorrente);
		this.partita.setStanzaVincente(stanzaVincente);
		assertFalse(partita.vinta());
	}
	
	@Test 
	public void testFinitaPercheVinta() {
		this.partita.setStanzaCorrente(stanzaVincente);
		this.partita.setStanzaVincente(stanzaVincente);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinita() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testFinitaForzatamente() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

}
