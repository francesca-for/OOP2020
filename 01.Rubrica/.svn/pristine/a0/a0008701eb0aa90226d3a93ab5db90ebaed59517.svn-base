package it.polito.oop.rubrica.classi;

public class Voce {
	
	public Voce(String nome, String cognome, String numTelefono) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numTelefono = numTelefono;
	}

	private String nome;  //mettendo public posso vederlo nel main, non è l'approccio giusto perchè non ho più il controllo su quell'elemento 
	private String cognome;
	private String numTelefono; // mettendo private posso accedere ai dati dal main attraverso metodi definiti in questa classe
	
	public String getNome() {  //non serve setNome perché si presuppone che il nome non cambi nel tempo
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	
	public String toString() {
		return nome + " " + cognome + " " + numTelefono;
	}
	
}
