package it.polito.oop.rubrica;
import it.polito.oop.rubrica.classi.Rubrica;

;

public class MainClass {

	public static void main(String[] args) {
		Rubrica r1 = new Rubrica("Prima Rubrica");
		
		System.out.println(r1.getNome());
		
		r1.setNome("Rubrica 1");
		
		System.out.println(r1.getNome());   // stampa nome della rubrica
		System.out.println("");
		
		r1.aggiungi("Francesca", "Fornasier", "0119393939");
		
		//a.setNome("Fra");
		//a.setCognome("Fornasier");
		//a.setNumTelefono("0932040244");
		
		System.out.println(r1.primo());
		System.out.println(r1.voce(-1));
		System.out.println(r1.voce(3));
		System.out.println(r1.voce(1));
		System.out.println(r1.elenco());
		System.out.println(r1.ricerca("esc"));
		System.out.println("");
		
		r1.aggiungi("Claudia", "Fossi", "0123456789");
		
		System.out.println(r1.primo());
		System.out.println(r1.voce(-1));
		System.out.println(r1.voce(2));
		System.out.println(r1.voce(3));
		System.out.println(r1.voce(1));
		System.out.println(r1.elenco());
		System.out.println(r1.ricerca("esc"));
		System.out.println(r1.ricerca("arm"));
		System.out.println(r1.ricerca("456"));
	}

}
