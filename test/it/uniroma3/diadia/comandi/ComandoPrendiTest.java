package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPrendiTest {
	
	private static final String ATTREZZO_DA_PRENDERE ="AttrezzoDaPrendere";
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private ComandoPrendi comandoPrendi;
	private Partita partita;
	
	@BeforeEach
	public void setUp() throws Exception{
		this.comandoPrendi = new ComandoPrendi();
		this.comandoPrendi.set(new IOConsole());
		this.partita = new Partita();
		Attrezzo attrezzoNuovo = new Attrezzo(ATTREZZO_DA_PRENDERE, 1);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzoNuovo);
	}

	@Test
	public void testEseguiAttrezzoPresente() {
		this.comandoPrendi.setParametro(ATTREZZO_DA_PRENDERE);
		this.comandoPrendi.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_PRENDERE));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_PRENDERE));
	}
	
	@Test
	public void testEseguiAttrezzoNonPresente() {
		String nonPresente ="attrezzoNonPresente";
		this.comandoPrendi.setParametro(nonPresente);
		this.comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(nonPresente));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_PRENDERE));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_PRENDERE));
	}
	
	@Test
	public void testEseguiBorsaPiena() {
		Borsa borsa = partita.getGiocatore().getBorsa();
		for(int i=0; i<DEFAULT_PESO_MAX_BORSA; i++)
			borsa.addAttrezzo(new Attrezzo("attrezzo"+i, 1));
		
		this.comandoPrendi.setParametro(ATTREZZO_DA_PRENDERE);
		this.comandoPrendi.esegui(partita);
		assertFalse(borsa.hasAttrezzo(ATTREZZO_DA_PRENDERE));
	}

}
