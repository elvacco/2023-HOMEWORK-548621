package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() { 
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}

	public int getPeso() {
		int pesoTotale = 0;
		for(Attrezzo a : this.attrezzi)
			pesoTotale += a.getPeso();
		return pesoTotale;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a;
			}
		}
		return null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		while(iteratore.hasNext()) 
			s.append(iteratore.next().toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		 ComparatorePerPeso comp = new ComparatorePerPeso();
		 Collections.sort(this.attrezzi, comp);
		 return this.attrezzi;
	}
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatorePerNome comp = new ComparatorePerNome();
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<Attrezzo>(comp);
		attrezziOrdinati.addAll(attrezzi);
		return attrezziOrdinati;
	}
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> map = new HashMap<>();
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		while(it.hasNext()) {
			Attrezzo temp = it.next();
			
			if(map.containsKey(temp.getPeso())) {
				Set<Attrezzo> set = map.get(temp.getPeso());
				set.add(temp);
				map.put(temp.getPeso(), set);
			} else {
				Set<Attrezzo> set = new HashSet<>();
				set.add(temp);
				map.put(temp.getPeso(), set);
			}
		}
		return map;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		ComparatorePrimaPesoPoiNome comp = new ComparatorePrimaPesoPoiNome();
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<Attrezzo>(comp);
		attrezziOrdinati.addAll(this.attrezzi);
		return attrezziOrdinati;
	}

}