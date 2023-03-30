package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	public final static int NUMERO_MAX_ATTREZZI = 10;
	private Borsa borsa;
	private Attrezzo attrezzo;

	@BeforeEach
	public void setUp() {
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("attrezzo", 1);
	}

	@Test
	void testAddAttrezzoPesoMaggioreDiPesoMax() {
		Attrezzo attrezzoPesante = new Attrezzo("attrezzo pesante", 10);
		this.borsa.addAttrezzo(attrezzoPesante);
		assertFalse(this.borsa.addAttrezzo(attrezzo));
	}

	@Test
	void testAddAttrezzoConBorsaPiena() {
		int i = 0;
		while(i<NUMERO_MAX_ATTREZZI) {
			this.borsa.addAttrezzo(attrezzo);
			i++;
		}
		assertFalse(this.borsa.addAttrezzo(attrezzo));
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(attrezzo));
	}

	@Test
	void testGetAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(this.borsa.getAttrezzo("attrezzo"), this.attrezzo);
	}

	@Test
	void testGetAttrezzoNonTrovato() {
		assertNull(this.borsa.getAttrezzo("attrezzo"));
	}

	@Test
	void testGetPeso() {
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(this.borsa.getPeso(), 1);
	}

	@Test
	void testIsEmpty() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	void testHasAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertTrue(this.borsa.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testHasAttrezzoNonPosseduto() {
		assertFalse(this.borsa.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertTrue(this.borsa.removeAttrezzo("attrezzo"));
	}
	
	@Test
	void testRemoveAttrezzoNonPosseduto() {
		assertFalse(this.borsa.removeAttrezzo("attrezzo"));
	}
	
	@Test
	void testToString() {
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(this.borsa.toString(), "Contenuto borsa (1kg/10kg): "+this.attrezzo.toString()+" ");
	}
	
	@Test
	void testToStringBorsaVuota() {
		assertEquals(this.borsa.toString(), "Borsa vuota");
	}

}
