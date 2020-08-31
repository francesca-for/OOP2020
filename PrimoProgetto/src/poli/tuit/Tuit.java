package poli.tuit;

public class Tuit {
	private String codice;
	private String testo;
	private Utente autore;
	
	Tuit(String codice, Utente autore, String testo){
		this.testo = testo;
		this.autore = autore;
		this.codice = codice;
	}

	public String getCodice() {
		return codice;
	}

	public String getTesto() {
		return testo;
	}

	public String getAutore() {
		return autore.getNome();
	}
	
}
