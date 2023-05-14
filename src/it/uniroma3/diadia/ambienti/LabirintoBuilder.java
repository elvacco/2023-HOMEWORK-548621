package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto{
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private List<Stanza> stanze;

	public LabirintoBuilder() {
		this.stanzaIniziale = null;
		this.stanzaVincente = null;
		this.stanze = new ArrayList<>();
	}

	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		this.stanzaIniziale = new Stanza(nomeStanza);
		this.setStanzaCorrente(stanzaIniziale);
		this.stanze.add(stanzaIniziale);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		this.stanzaVincente = new Stanza(nomeStanza);
		this.setStanzaVincente(stanzaVincente);
		this.stanze.add(stanzaVincente);
		return this;
	}

	public Labirinto getLabirinto() {
		return (Labirinto)this;
	}

	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Stanza ultima = this.stanze.get(this.stanze.size()-1);
		ultima.addAttrezzo(new Attrezzo(attrezzo, peso));
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
		Iterator<Stanza> it = this.stanze.iterator();
		Stanza corrente = null;
		Stanza adiacente = null;
		while(it.hasNext()) {
			Stanza s = it.next();
			if(s.getNome().equals(stanzaCorrente))
				corrente = s;
			if(s.getNome().equals(stanzaAdiacente))
				adiacente = s;
		}
		corrente.impostaStanzaAdiacente(direzione, adiacente);
		return this;
	}

	public LabirintoBuilder addStanza(String nome) {
		this.stanze.add(new Stanza(nome));
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String stanza, String attrezzo) {
		this.stanze.add(new StanzaBuia(stanza, attrezzo));
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome) {
		this.stanze.add(new StanzaMagica(nome));
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome, int sogliaMagica) {
		this.stanze.add(new StanzaMagica(nome, sogliaMagica));
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String stanza, String attrezzo, String direzione) {
		this.stanze.add(new StanzaBloccata(stanza, attrezzo, direzione));
		return this;
	}



	@Override
	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}

	@Override
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	@Override
	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaIniziale = stanza;
	}

	@Override
	public void setStanzaVincente(Stanza stanza) {
		this.stanzaVincente = stanza;
	}

	public List<Stanza> getListaStanze(){
		return this.stanze;
	}

}
