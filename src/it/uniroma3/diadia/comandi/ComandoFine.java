package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	private IO io;
	public static final String MESSAGGIO_FINE = "Grazie di aver giocato!";
	private static final String NOME = "fine";

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		this.io.mostraMessaggio(MESSAGGIO_FINE); 
	}

	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public void set(IO io) {
		this.io = io;
	}
	
	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
