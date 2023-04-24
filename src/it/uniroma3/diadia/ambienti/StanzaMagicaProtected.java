package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	
	static final public int SOGLIA_MAGICA_DEFAULT=3;

	protected int contatore;

	protected int sogliaMagica;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}


	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatore=0;
		this.sogliaMagica=soglia;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.contatore<this.sogliaMagica) {
			//Il comportamento non è ancora magico
			return super.addAttrezzo(attrezzo);
		}
		else {
			attrezzo=modficaAttrezzo(attrezzo);
			return false;
		}
	}


	private Attrezzo modficaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito  = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
}
