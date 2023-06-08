package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	private static final String MESSAGGIO_RINGHIO = "WOAF WAOF! Ti tolgo 5 CFU!!";
	private static String CIBO_PREFERITO= "osso";

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_RINGHIO;
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu-5);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Bau grazie per avermi regalato ");

		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			risposta.append("il mio cibo preferito.");
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("collare", 2));
		} else {
			risposta.append(attrezzo.getNome()+",ma non e' il mio cibo preferito, bau!");
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}

		return risposta.toString();
	}

}
