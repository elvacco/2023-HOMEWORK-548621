package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	private IO io;
	private static final String NOME = "guarda";

	@Override
	public void esegui(Partita partita) {

		io.mostraMessaggio("Stanza: " + partita.getStanzaCorrente().getDescrizione() + ".\n");
		io.mostraMessaggio("Lo stato della partita risulta essere: \n" +
				"Cfu -> " + partita.getGiocatore().getCfu() + "\n" +
				"Borsa -> " + partita.getGiocatore().getBorsa().toString() + ".\n");
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
