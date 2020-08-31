package generics;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class EsempiGenerici {
	
	public static void main(String[] args) {
		String[] parole = "Alla fiera dell est per due soldi un topolino".split(" ");
		
		countNotNullS(parole); // varsione specifica per stringhe
		countNotNull(parole); // versione generale per Object
		
		countIfEqualNG(parole,"per");
		countIfEqualNG(parole,42); // sintatticamente corretto ma privo di senso
		
		countIfEqual(parole,"per");  // il compilator sostituisce T con String
		countIfEqual(parole,42);  // il compilator sostituisce T con Object
		//EsempiGenerici.<String>countIfEqual(parole,42);  // dichiaro che T deve essere sostituito con String
	
		//                    vvvvvvvvvv
		Predicate<String> lunghezzaAlmenoTre = (String s) -> s.length() > 2;  // è un oggetto verificatore
		//                                  ^^^^^^^^^^^^^^
		lunghezzaAlmenoTre = s -> s.length() > 2; // il compilatore "inferisce" il tipo di s 
		// il tipo è non solo Verifica ma bensì Verifica<String>
		// EQUIVALE
		lunghezzaAlmenoTre = new Predicate<String>() {
			//                     vvvvvvvvvv
			public boolean test(String s) {
				return s.length() > 2;
				//     ^^^^^^^^^^^^^^
			}
		};
		
		countIf(parole,lunghezzaAlmenoTre);
		
		countIf(parole, parola -> parola.length() > 2);
		EsempiGenerici.<String>countIf(parole, parola -> parola.length() > 2);
		
		countIfNG(parole, parola -> ((String)parola).length() > 2);
		
		
		// Inoltre ho dei controlli fatti dal compilatore
		// che garantiscono la coerenza tra i tipi
		
		Verifica<Integer> vi = i -> i.intValue() > 2;
		
		//countIf(parole, vi); 
		/* ERRORE di compilazione:
		The method countIf(T[], EsempiGenerici.Verifica<T>) 
		in the type EsempiGenerici is not applicable 
		for the arguments (String[], EsempiGenerici.Verifica<Integer>)
		*/
		
		//countIf(parole, (Integer i) -> i.intValue() > 2);
		
		// countIf(parole, i -> i.intValue() > 2);
		
		countIfNG(parole, i -> ((Integer)i).intValue() > 2);
		
		// esempio di interfaccia funzionale con più parametri di tipo
		BiFunction<Integer,Double,String> bf = (i,d) -> "Risultato: " + (i.intValue() + d.doubleValue());
	//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^         ^^^
	//      tipo target                      parametri
		// In base al tipo target il compilatore può inferire i tipi dei parametri e del valore di ritorno
	}
	
	/**
	 * Interfaccia generica per verificatori
	 *
	 * @param <T>o oggetto da verificare 
	 */
	interface Verifica<T> {
		boolean test(T o);
		default Verifica<T> negato(){
			return o -> ! this.test(o);
		}
	}
	
	interface VerificaNonGenerica {
		boolean verifica(Object o);
	}
	
	VerificaNonGenerica v1 = o -> ((String)o).length() > 2;
	
	VerificaNonGenerica v = new VerificaNonGenerica() {
		public boolean verifica(Object o) {
			String s = (String)o;
			return s.length() > 2;
		}
	};


	
	/**
	 * Conta gli elementi all'interno di un array che soddisfano
	 * un condizione verificata da un verificatore.
	 * 
	 * @param v l'array in cui contare
	 * @return il conteggio degli elementi uguali a quello dato
	 */
	public static <T> int countIf(T[] v, Predicate<T> verificatore) {
		if( v == null ) return 0;
		int count=0;
		for(T s : v) {
			if( s!=null && verificatore.test(s) ) ++count;
		}
		return count;
	}
	
	public static int countIfNG(Object[] v, VerificaNonGenerica verificatore) {
		if( v == null ) return 0;
		int count=0;
		for(Object s : v) {
			if( s!=null && verificatore.verifica(s) ) ++count;
		}
		return count;
	}


	
	/**
	 * Conta gli elementi uguali ad un elemento dato, all'interno di un array.
	 * 
	 * @param v l'array in cui contare
	 * @return il conteggio degli elementi uguali a quello dato
	 */
	public static <T> int countIfEqual(T[] v, T element) {
		if( v == null ) return 0;
		int count=0;
		for(T s : v) {
			if( s!=null && s.equals(element) ) ++count;
		}
		return count;
	}
	
	/**
	 * Conta gli elementi uguali ad un elemento dato, all'interno di un array.
	 * 
	 * @param v l'array in cui contare
	 * @return il conteggio degli elementi uguali a quello dato
	 */
	public static int countIfEqualNG(Object[] v, Object element) {
		if( v == null ) return 0;
		int count=0;
		for(Object s : v) {
			if( s!=null && s.equals(element) ) ++count;
		}
		return count;
	}
	
	/**
	 * Conta gli elementi non nulli all'interno di un array generico.
	 * 
	 * @param v l'array in cui contare
	 * @return il conteggio degli elementi non nulli
	 */
	public static int countNotNull(Object[] v) {
		if( v == null ) return 0;
		int count=0;
		for(Object s : v) {
			if(s!=null) ++count;
		}
		return count;
	}
	
	/**
	 * Conta gli elementi non nulli all'interno di un array di stringhe.
	 * 
	 * @param v l'array in cui contare
	 * @return il conteggio degli elementi non nulli
	 */
	public static int countNotNullS(String[] v) {
		if( v == null ) return 0;
		int count=0;
		for(String s : v) {
			if(s!=null) ++count;
		}
		return count;
	}

}
