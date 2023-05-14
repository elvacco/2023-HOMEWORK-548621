package it.uniroma3.diadia;

import java.util.LinkedList;
import java.util.List;

public class IOSimulator implements IO{
	
	private List<String> righeDaLeggere;
	private List<String> messaggiProdotti;
	
	public IOSimulator(List <String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.messaggiProdotti = new LinkedList <String>();
	}

	@Override
	public String leggiRiga() {
		if(!righeDaLeggere.isEmpty())
			return righeDaLeggere.remove(0);
		else
			return null;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		messaggiProdotti.add(messaggio);
	}
	
	public String nextMessaggio() {
		if(this.hasNextMessaggio())
			return messaggiProdotti.remove(0);
		else
			return null;
	}
	
	public boolean hasNextMessaggio() {
		return !this.messaggiProdotti.isEmpty();
	}
	
}
