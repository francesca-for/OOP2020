package poli.tuit;

import java.util.Collection;
import java.util.LinkedList;

public class Utente {

	private String nome;
	private String email;
	
	private Collection<Tuit> tuits = new LinkedList<>();
	
	Utente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void nuovoTuit(Tuit t) {
		tuits.add(t);
	}
	
	public int numeroTuit() {
		return tuits.size();
	}
	
	
}
