package generics;

import java.util.Arrays;

public class VettoreOrdinato extends Vettore {
	private String nome;

	// Implicitamente il compilatore ha generato un ctor vuoto
	public VettoreOrdinato() {
		// chiamata al costruttore senza parametri della classe di base
		super();
	}

	public VettoreOrdinato(int dimensioneIniziale) {
		super(dimensioneIniziale);
		nome = "Vettore ordinato";
	}

	public void add(int elemento) {
	   if(next==elementi.length) {
		   resize();
	   }
		//		   elementi[next++] = elemento;
		super.add(elemento);

		Arrays.sort(elementi,0,next);

		// Altre possibili varianti (esercizio)

		// - dopo l'aggiunta, faccio scorrere l'elemento nella sua posizione
		// - uso una ricerca (es. bynarySearch) per trovare la posizione in cui inserire
	}
}
