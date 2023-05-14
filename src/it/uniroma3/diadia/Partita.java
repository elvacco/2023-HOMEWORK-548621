package it.uniroma3.diadia;
import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Labirinto
 * @version base
 */

public class Partita {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private IO io;
	private List<String> percorso;

	public Partita(){
		this.labirinto = new Labirinto();
		this.stanzaCorrente = this.labirinto.getStanzaCorrente();
		this.finita = false;
		this.giocatore = new Giocatore();
		this.io = new IOConsole();
		this.percorso= new ArrayList<String>();
	}

	public Partita(Labirinto lab){
		labirinto = lab;
		this.stanzaCorrente = this.labirinto.getStanzaCorrente();
		this.stanzaVincente = labirinto.getStanzaVincente(); 
		this.finita = false;
		giocatore = new Giocatore();
		this.io = new IOConsole();
		this.percorso= new ArrayList<String>();
	}

	public void setLabirinto(Labirinto lab) {
		this.labirinto = lab;
	}


	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}



	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.percorso.add(stanzaCorrente.getNome());
		this.stanzaCorrente = stanzaCorrente;
	}



	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}



	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}


	public String getPercorso(int tappe) {
		return this.percorso.get(tappe);
	}


	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente == this.stanzaVincente;
	}


	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || ((this.giocatore.getCfu()) == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


	public Giocatore getGiocatore() {
		return giocatore;
	}


	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public IO getIO() {
		return io;
	}

}
