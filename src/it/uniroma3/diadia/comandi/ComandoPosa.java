package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "posa";
	
	@Override
	public void esegui(Partita partita) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		Attrezzo attrezzoDaPosare= borsa.getAttrezzo(getParametro());
		if(attrezzoDaPosare==null) {
			this.io.mostraMessaggio("Attrezzo "+ nomeAttrezzo + " non presente nella borsa.");
			return;
		}
		boolean attrezzoPosato = partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
		if(!attrezzoPosato) {
			this.io.mostraMessaggio("Non c'e' piu' spazio per gli attrezzi, la stanza e' piena!");
			return;
		}
			
		borsa.removeAttrezzo(getParametro());
		this.io.mostraMessaggio("Attrezzo " + getParametro() + " posato!");

	}

	@Override
	public void set(IO io) {
		this.io = io;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
