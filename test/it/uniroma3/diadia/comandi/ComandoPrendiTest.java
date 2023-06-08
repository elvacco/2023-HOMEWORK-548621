package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Comando comando;
	private IO io;
	Labirinto labirinto;

	@BeforeEach
	public void setUp() throws Exception {
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("martello", 2);
		new Attrezzo("incudine", 11);
		comando = new ComandoPrendi();
		io = new IOConsole(null);
		comando.set(io);
	}


	@AfterEach
	public void tearDown() throws Exception {
	}

	public boolean attrezzoPresente(String s) {
		if(partita.getStanzaCorrente().getAttrezzo(s)==null)
			return false;
		return true;
	}

	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}

	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}

}
