package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	private static final String ATTREZZO = "attrezzoSemplice";
	private Borsa borsa;
	private static final int PESO_MAX_BORSA = 20;

	@BeforeEach
	public void setUp() {
		this.borsa = new Borsa(PESO_MAX_BORSA);
	}

	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzo = creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testAddAttrezzoTroppoPesante() {
		Attrezzo attrezzoPesante = new Attrezzo("attrezzoPesante", PESO_MAX_BORSA+1);
		assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
	}

	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testGetAttrezzoInesistente() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertNull(this.borsa.getAttrezzo("inesistente"));
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(PESO_MAX_BORSA, this.borsa.getPesoMax());
	}

	@Test
	public void testGetPesoIniziale() {
		assertEquals(0, this.borsa.getPeso());
	}

	@Test
	public void testGetPesoDopoAggiuntaAttrezzo() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertEquals(1, this.borsa.getPeso());
	}

	@Test
	public void testRemoveAttrezzo() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		this.borsa.removeAttrezzo(ATTREZZO);
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testRemoveAttrezzoPesoZero() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		this.borsa.removeAttrezzo(ATTREZZO);
		assertEquals(0, this.borsa.getPeso());
	}

	private Attrezzo creaAttrezzoEAggiungiBorsa(Borsa borsa, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		borsa.addAttrezzo(attrezzo);
		return attrezzo;
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		Attrezzo spada = new Attrezzo("spada", 5);
		Attrezzo coltello = new Attrezzo("coltello", 1);
		Attrezzo osso = new Attrezzo("osso",1);
		this.borsa.addAttrezzo(spada);
		this.borsa.addAttrezzo(coltello);
		this.borsa.addAttrezzo(osso);

		assertEquals("[coltello (1kg), osso (1kg), spada (5kg)]", this.borsa.getContenutoOrdinatoPerPeso().toString());
	}

	@Test
	public void testGetContenutoOrdinatoPerNome() {
		Attrezzo spada = new Attrezzo("spada", 5);
		Attrezzo coltello = new Attrezzo("coltello", 3);
		Attrezzo osso = new Attrezzo("osso",1);
		this.borsa.addAttrezzo(spada);
		this.borsa.addAttrezzo(coltello);
		this.borsa.addAttrezzo(osso);

		assertEquals("[coltello (3kg), osso (1kg), spada (5kg)]", this.borsa.getContenutoOrdinatoPerNome().toString());
	}
}
