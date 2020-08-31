package ereditarieta;

public class EsempiObject extends Object /* aggiunto implicitamente dal compil */ {

	private static final int NON_TROVATO = -1;

	static class Esempio { // implicitamente extends Object
		int i;
		Esempio(int i){ this.i = i; }
		@Override
		public String toString() {
			return "Ex (" + i + ")";
		}
		
		@Override
		public boolean equals(Object other) {
			if( other instanceof Integer) {
				return this.i == ((Integer)other).intValue();
			}
			if( other instanceof String) {
				return this.i == Integer.parseInt((String)other);
			}
			if( other instanceof Esempio ) {
				Esempio altro = (Esempio)other;  // downcast
				return this.i == altro.i;
			}

			return false;
		}
		
		public boolean uguali(Esempio altro) {
			return this.i == altro.i;
		}
	}
	
	public static void main(String[] args) {
		Esempio e = new Esempio(42);
		
		String s = e.toString();
		
		System.out.println(s);
		
		Esempio f = new Esempio(42);
		
		System.out.println("Confronto di riferimenti: " + ( e == f ));
		
		System.out.println("Confronto di contenuti: " + ( e.equals(f) ));
		
		System.out.println("Confronto di contenuti: " + ( e.uguali(f) ));
		
		String[] nomi = {"Andrea","Beatrice","Carlo","Diletta","Zorro"};
		
		int indice = trova("Beatrice",nomi); // usa override di equals() in String
		
		System.out.println("Trovato alla posizione " + indice);
		
		Esempio[] elementi = {new Esempio(1), new Esempio(10), new Esempio(8) };
		
		System.out.println("Trovato" + trova(new Esempio(8), elementi)); // usa l'override di equals() in Esempio
		
		e.equals("42");
		e.equals(null);
	}

	/**
	 * Cerca un elemento all'interno di un array e 
	 * restituisce l'indice di tale elemento.
	 * 
	 * Se non lo trova restituisce -1.
	 * 
	 * @param elemento elemento da trovare
	 * @param array		array in cui fare la ricerca
	 * @return indice dell'elemento.
	 */
	public static int trova(Object elemento, Object[] array) {
		for(int i=0; i<array.length; ++i) {
			if(elemento.equals(array[i])) {
				return i;
			}
		}
		return NON_TROVATO;
	}
	
	
}
