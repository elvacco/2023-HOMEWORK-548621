package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};

	private IOConsole ioconsole;
	private Partita partita;
	private Giocatore giocatore;
	private Borsa borsa;

	public DiaDia() {
		this.ioconsole = new IOConsole();
		this.partita = new Partita();
		this.giocatore = partita.getGiocatore();
		this.borsa = giocatore.getBorsa();
	}

	public void gioca() {
		String istruzione; 

		this.ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = this.ioconsole.leggiRiga();
		while (!processaIstruzione(istruzione));		
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		String nome = comandoDaEseguire.getNome();

		if (nome==null)
			this.ioconsole.mostraMessaggio("Comando sconosciuto");
		else if (nome.equals("fine")) {
			this.fine(); 
			return true;
		} else if (nome.equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (nome.equals("aiuto"))
			this.aiuto();
		else if(nome.equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(nome.equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			this.ioconsole.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.ioconsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.ioconsole.mostraMessaggio(elencoComandi[i]);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.ioconsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.ioconsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			this.giocatore.setCfu(cfu--);
		}
		this.ioconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo==null)
			this.ioconsole.mostraMessaggio("Quale attrezzo vuoi prendere?");
		if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			this.borsa.addAttrezzo(attrezzo);
			this.partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
		}
		else
			this.ioconsole.mostraMessaggio("Attrezzo inesistente");
	}

	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo==null)
			this.ioconsole.mostraMessaggio("Quale attrezzo vuoi posare?");
		else
		if(this.borsa.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = this.borsa.getAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
			this.borsa.removeAttrezzo(nomeAttrezzo);
		}
		else
			this.ioconsole.mostraMessaggio("Attrezzo non presente nella borsa");
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}