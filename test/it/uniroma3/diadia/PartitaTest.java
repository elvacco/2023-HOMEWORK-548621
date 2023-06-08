package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

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
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = Labirinto.newBuilder("labirinto5.txt").getLabirinto();
		this.stanzaCorrente = labirinto.getStanzaCorrente();
		this.stanzaVincente = labirinto.getStanzaVincente();
		partita = new Partita(this.labirinto); 
	}

	@Test
	public void testVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testNonVinta() {
		this.partita.setStanzaCorrente(stanzaCorrente);
		this.partita.getLabirinto().setStanzaVincente(stanzaVincente);
		assertFalse(partita.vinta());
	}
	
	@Test 
	public void testFinitaPercheVinta() {
		this.partita.setStanzaCorrente(stanzaVincente);
		this.partita.getLabirinto().setStanzaVincente(stanzaVincente);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinitaForzatamente() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

}
