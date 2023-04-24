package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private static final String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		if(!partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {
			this.io.mostraMessaggio("Attrezzo "+ this.nomeAttrezzo + " non presente nella stanza.");
			return;
		}
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		partita.getStanzaCorrente().removeAttrezzo(attrezzo.getNome());
		io.mostraMessaggio("Attrezzo "+ this.nomeAttrezzo + " preso!");

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		}
	
	@Override
	public void set(IO io) {
		this.io = io;
	}
	
	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
