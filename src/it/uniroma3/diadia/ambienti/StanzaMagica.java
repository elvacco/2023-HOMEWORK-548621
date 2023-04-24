package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{
	
	static final public int SOGLIA_MAGICA_DEFAULT=3;
	
	private int contatore;

	private int sogliaMagica;
	
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatore=0;
		this.sogliaMagica=soglia;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.contatore<this.sogliaMagica) {
			//Il comportamento non è ancora magico
			this.contatore++;
			return super.addAttrezzo(attrezzo);
		}
		else {
			attrezzo=modificaAttrezzo(attrezzo);
			return super.addAttrezzo(attrezzo);
		}
	}


	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito  = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
	
	
}
