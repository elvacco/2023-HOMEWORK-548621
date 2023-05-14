package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe ha il compito di modellare la mappa del gioco
 * e di memorizzare la stanza iniziale (entrata) e la stanza finale (uscita)
 * 
 * @author lorenzovaccarotti
 * @see Stanza
 */

public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	public Labirinto() {
		creaStanze();
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	private void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);  
		Attrezzo computer = new Attrezzo("computer",5);
		Attrezzo spada = new Attrezzo("spada",4);
		Attrezzo piedediporco = new Attrezzo("piedediporco", 4);

		/* crea stanze del labirinto */
		Stanza atrio = new StanzaMagica("Atrio");
		Stanza aulaN11 = new StanzaMagica("Aula N11");
		Stanza aulaN10 = new StanzaMagica("Aula N10");
		Stanza laboratorio = new StanzaMagica("Laboratorio Campus");
		Stanza biblioteca = new StanzaMagica("Biblioteca");
		StanzaBloccata bagno = new StanzaBloccata("bagno", "piedediporco", "sud");
		StanzaBuia sgabuzzino = new StanzaBuia("sgabuzzino", "lanterna");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("nord", bagno);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("sud", sgabuzzino);
		bagno.impostaStanzaAdiacente("sud", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		sgabuzzino.impostaStanzaAdiacente("nord", laboratorio);

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		aulaN10.addAttrezzo(spada);
		atrio.addAttrezzo(osso);
		aulaN11.addAttrezzo(spada);
		laboratorio.addAttrezzo(computer);
		laboratorio.addAttrezzo(osso);
		laboratorio.addAttrezzo(lanterna);
		bagno.addAttrezzo(piedediporco);


		// il gioco comincia nell'atrio
		stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
	}


	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
}
