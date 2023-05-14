package it.uniroma3.diadia.ambienti;


import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private Map<String, Stanza> stanzaMap;
	private Attrezzo attrezzo;
	private Stanza stanza;
	
	@BeforeEach
	public void setUp() {
		this.stanzaMap = new HashMap<String,Stanza>();
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.stanza = new Stanza("stanza");
	}
	
	@Test
	public void testImpostaStanzaAdiacenteSingola() {
		Stanza stanzaAdiacente = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "stanzaAdiacente", "nord");
		assertEquals(this.stanzaMap.get("nord"), stanzaAdiacente);
	}
	
	@Test
	public void testCambiaStanzaAdiacente() {
		Stanza stanzaAdiacente = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "stanzaAdiacente", "nord");
		Stanza nuovaAdiacente = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "nuovaAdiacente", "nord");
		assertEquals(nuovaAdiacente, this.stanzaMap.get("nord"));
		assertNotEquals(stanzaAdiacente, this.stanzaMap.get("nord"));
	}
	
	@Test
	public void testImpostaMassimo4Stanze() {
		Stanza adiacente = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "adiacente", "nord");
		String[] direzioni = {"nord", "sud", "est", "ovest"};
		for(String direzione : direzioni)
			this.stanza.impostaStanzaAdiacente(direzione, adiacente);
		
		String nuovaDirezione = "nord-ovest";
		Stanza stanzaInPiu = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "stanzaInPiu", nuovaDirezione);
		
		assertNotEquals(stanzaInPiu, this.stanza.getStanzaAdiacente(nuovaDirezione));
	}
	
	@Test
	public void testStanzaAdiacenteInesistente() {
		assertNull(this.stanzaMap.get("nord"));
	}
	
	@Test
	public void testGetDirezioneSingola() {
		Stanza adiacente = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "stanzaAdiacente", "nord");
		Set<String> direzioni = new HashSet<String>();
		direzioni.add("nord");
		assertEquals(adiacente, this.stanzaMap.get("nord"));
		assertEquals(direzioni, this.stanzaMap.keySet());
	}
	
	@Test
	public void testGetQuattroDirezioni() {
		Stanza salone = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "salone", "nord");
		Stanza cucina = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "cucina", "sud");
		Stanza camera = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "camera", "est");
		Stanza bagno = creaStanzaImpostaStanzaAdiacente(this.stanzaMap, "bagno", "ovest");
		
		Set<String> direzioni = new HashSet<String>();
		direzioni.add("nord");
		direzioni.add("sud");
		direzioni.add("est");
		direzioni.add("ovest");
		
		assertEquals(salone, this.stanzaMap.get("nord"));
		assertEquals(cucina, this.stanzaMap.get("sud"));
		assertEquals(camera, this.stanzaMap.get("est"));
		assertEquals(bagno, this.stanzaMap.get("ovest"));
		assertEquals(direzioni, this.stanzaMap.keySet());
	}
	
	@Test
	public void testAddSingoloAttrezzo() {
		this.stanza.addAttrezzo(attrezzo);
		assertEquals(this.stanza.getAttrezzo("attrezzo"), attrezzo);
	}
	
	@Test
	public void testAddAttrezzoDiTroppo() {
		for(int i=0; i<=NUMERO_MASSIMO_ATTREZZI; i++) {
			this.stanza.addAttrezzo(this.attrezzo);
		}
		
		Attrezzo attrezzoDiTroppo = new Attrezzo("attrezzoDiTroppo", 2);
		this.stanza.addAttrezzo(attrezzoDiTroppo);
		assertFalse(this.stanza.hasAttrezzo("attrezzoDiTroppo"));
	}
	
	@Test
	public void testHasAttrezzoSingolo() {
		this.stanzaMap.put("attrezzo", stanza);
		assertTrue(this.stanzaMap.containsKey("attrezzo"));
	}
	
	@Test
	public void testHasAttrezzoNonPresente() {
		assertFalse(this.stanzaMap.containsKey("nomeAttrezzo"));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		this.stanzaMap.put(attrezzo.getNome(), stanza);
		this.stanzaMap.remove(attrezzo.getNome());
		assertFalse(this.stanzaMap.containsKey(stanza.getNome()));
	}
	
	
	
	public Stanza creaStanzaImpostaStanzaAdiacente(Map<String, Stanza> stanzaPartenza, String nomeStanzaAdiacente, String direzione) {
		Stanza stanzaAdiacente = new Stanza(nomeStanzaAdiacente);
		stanzaPartenza.put(direzione, stanzaAdiacente);
		return stanzaAdiacente;
	}
}
