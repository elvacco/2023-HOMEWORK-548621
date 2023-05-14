package it.uniroma3.diadia.giocatore;

import java.util.Comparator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComparatorePerNome implements Comparator<Attrezzo>{
	
	@Override
	public int compare(Attrezzo a, Attrezzo b) {
		if(a.getNome().compareTo(b.getNome()) < 0)
			return -1;
		if(a.getNome().compareTo(b.getNome()) == 0)
			return 0;
		else 
			return 1;
	}

}
