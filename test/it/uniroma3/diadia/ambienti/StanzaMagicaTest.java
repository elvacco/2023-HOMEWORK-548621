package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {

	static final private String NOME_STANZA = "magica";
	static final private int SOGLIA_MAGICA = 3;
	
	private StanzaMagica magica;
	private Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp() {
		this.magica = new StanzaMagica(NOME_STANZA, SOGLIA_MAGICA);
		this.attrezzo = new Attrezzo("asso", 1);
	}
	
	@Test
	public void testAddAttrezzoNonostanteLaSogliaMagica() {
		for(int i=0; i<SOGLIA_MAGICA; i++) {
			this.magica.addAttrezzo(attrezzo);
		}
		assertTrue(this.magica.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testPesoRaddoppiato() {
		for(int i=0; i<SOGLIA_MAGICA; i++) {
			this.magica.addAttrezzo(attrezzo);
		}
		this.magica.addAttrezzo(attrezzo);
		assertTrue(this.magica.getAttrezzo("ossa").getPeso() == 2);
	}
	
	@Test
	public void testNomeInvertito() {
		for(int i=0; i<SOGLIA_MAGICA; i++) {
			this.magica.addAttrezzo(attrezzo);
		}
		this.magica.addAttrezzo(attrezzo);
		assertTrue(this.magica.hasAttrezzo("ossa"));
	}
}
