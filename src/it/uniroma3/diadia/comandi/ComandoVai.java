package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;
	private IO io;
	private final static String NOME = "vai";
	
	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {

		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;

		if(direzione==null) {
			this.io.mostraMessaggio("Dove vuoi andare ? Devi specificare una direzione");    ;
			return;
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");;
			return;
		}

		partita.setStanzaCorrente(prossimaStanza);
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	
	@Override
	public void set(IO io) {
		this.io = io;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.getParametro();
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
