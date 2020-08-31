package poli.tuit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class FacciataTuit {
	
	private static final int LUNGHEZZA_MASSIMA = 140;
	private Map<String,Utente> utenti = new HashMap<>();

	public void nuovoUtente(String nome, String email) {
		
		Utente u = new Utente(nome,email);
		
		utenti.put(nome, u);
	}

	public boolean esisteUtente(String nome) {
		return utenti.containsKey(nome);
	}

	public String emailOf(String nome) {
		Utente u = utenti.get(nome);
		return u.getEmail();
	}

	
	static int codiceTuit=1;
	public String nuovoTuit(String autore, String testo) throws TuitException {
	
		if( testo.length() > LUNGHEZZA_MASSIMA) {
			throw new TuitException("Teso superiore a lunghezza massima");
		}
		Utente a = utenti.get(autore);
		
		String codice;
		// Alternativa 1
		// codice = Integer.toString(codiceTuit++);
		
		// Alternativa 2
		//codice = t.toString(); // poli.tuit.Tuit@a34512
		
		// Alternativa 3
		// genero una sequenza casuale di numeri e lettere;
		codice = generaIdentificatore();
		
		Tuit t = new Tuit(codice,a,testo);
		
		tweets.put(codice, t);

		a.nuovoTuit(t);

		return codice;
		
	}
	
	final static String caratteri = "0123456789abcdefghijklmnopqrstuvwxyz";
	private Random generatore = new Random(123);
	private Map<String,Tuit> tweets = new HashMap<>();
	public String generaIdentificatore() {
		String codice=""; // meglio un char[]
		boolean duplicato=true;
		while(duplicato) {
			codice ="";
			for(int i =0; i<30; ++i) {
				int indice = generatore.nextInt(caratteri.length());
				codice += caratteri.charAt(indice);
			}
			duplicato = tweets.containsKey(codice);
		}
		return codice;
	}

	public int numeroTuit(String autore) {
		Utente a = utenti.get(autore);
		
		return a.numeroTuit();
	}

	public String getTesto(String id) {
		return tweets.get(id).getTesto();
	}

	public String getAutore(String id) {
		return tweets.get(id).getAutore();
	}

	public String nuovaRisposta(String id, String autore, String testo) throws TuitException {
		
		if( testo.length() > LUNGHEZZA_MASSIMA) {
			throw new TuitException("Teso superiore a lunghezza massima");
		}
		Utente a = utenti.get(autore);
		
		String codice;
		// Alternativa 1
		// codice = Integer.toString(codiceTuit++);
		
		// Alternativa 2
		//codice = t.toString(); // poli.tuit.Tuit@a34512
		
		// Alternativa 3
		// genero una sequenza casuale di numeri e lettere;
		codice = generaIdentificatore();
		
		Tuit t = new Tuit(codice,a,testo);
		
		tweets.put(codice, t);

		a.nuovoTuit(t);
		
		return codice;
	}

}
