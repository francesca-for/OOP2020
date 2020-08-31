package it.polito.oop.rubrica.classi;

public class Rubrica {
	private String nome;
	
	private final int MAX_VOCI = 100;
	private int next=0;

	private Voce[] voci = new Voce[MAX_VOCI];  // creo array di voci
	
	public Rubrica (String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void aggiungi(String nome, String cognome, String numTel) {
		Voce v = new Voce(nome, cognome, numTel);  //creo nuova voce
		
		if(next<MAX_VOCI) {
			voci[next]=v;  //salvo nel vettore di voci la voce corrente
			next++;
		}
		else System.err.println("Impossibile aggiungere voce: rubrica piena");
	}
	
	public String primo() {   //primo elemento
		if(next!=0)
			return voci[0].getNome()+" "+voci[0].getCognome()+" "+voci[0].getNumTelefono();
		else 
			return "Rubrica vuota";       //System.out.println("Rubrica vuota"); ??
	} 
	
	public String voce(int indice) {
		if(indice<0)
			return "L'indice deve essere >0";
		else if(indice>next)
			return "Indice troppo alto";
		else return voci[indice-1].toString();
	}
	
	public String elenco() {
		String output = "";
		if(next==0)
			return output+"Rubrica vuota";
		output+="( ";
		for(int ind=0; ind<next; ind++) {
			output += voci[ind].toString();
			if(ind<next-1)
				output+=", ";
		}
		return output+" )";
	}
	
	public String ricerca(String strChiave) {
		String output="Voce non trovata";
		
		for(Voce v : voci) {
			if(v==null)
				break;
			if(v.getNome().contains(strChiave) || v.getCognome().contains(strChiave) || v.getNumTelefono().contains(strChiave)) {
				output="Trovato: "+v.toString();
				break;
			}
		}
		return output;
	}
	
}
