package it.polito.oop.rubrica;
import it.polito.oop.rubrica.classi.*;

public class MainClass {

	public static void main(String[] args) {
		Rubrica rubrica1 = new Rubrica("Prima rubrica");

		System.out.println(rubrica1.getNome());

		rubrica1.setNome("1a rubrica");

		System.out.println(rubrica1.getNome());

//		Voce v1 = new Voce("Giorgio", "Bruno", "0110900000");
//		Voce v2 = new Voce("Marco", "Torchiano", "0110900001");
//
//		System.out.println(v1);
//		System.out.println(v2);

//		for(int i=0; i<101; i++)
//		{
//			rubrica1.aggiungi("Giorgio", "Bruno", "0110900000");
//		}

		rubrica1.aggiungi("Giorgio", "Bruno", "0110900000");

		System.out.println(rubrica1.primo());

		System.out.println(rubrica1.voce(1));
		System.out.println(rubrica1.voce(0));
		System.out.println(rubrica1.voce(-1));
		System.out.println(rubrica1.voce(2));

		rubrica1.aggiungi("Marco", "Torchiano", "0110900001");
		System.out.println(rubrica1.voce(2));

		System.out.println(rubrica1.elenco());

		System.out.println(rubrica1.ricerca("Giorgio"));
		//System.out.println(rubrica1.ricerca("Torc"));
		//System.out.println(rubrica1.ricerca("011"));
	}

}
