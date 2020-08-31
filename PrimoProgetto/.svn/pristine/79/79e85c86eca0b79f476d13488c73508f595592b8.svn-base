package stream;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.Comparator;

public class EsempiStream {

	public static void main(String[] args) {
		
		String[] parole = data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ \n.\"]+");
		
		for(String p : parole) {
			System.out.println(p);
		//  ^^^^^^^^^^^^^^^^^^^^^
		}
		
		
		Stream.of(parole).forEach( p -> System.out.println(p) );
									//  ^^^^^^^^^^^^^^^^^^^^^
		// oppure spezzando:
		
		Stream<String> streamDiParole = Stream.of(parole);  // nessuna operazione viene fatta
		
		streamDiParole.forEach( p -> System.out.println(p) ); // scatena le operazione
		
//		System.out.println("Ripetizione di forEach");
//		streamDiParole.forEach( p -> System.out.println(p) ); // scatena le operazione
		
		// FILTRARE le parole che iniziano con "A"
		
		// FILTRARE le parole che iniziano con "A"
		System.out.println("------- FILTER ------ ");
		Stream.of(parole)
		           // vvvvvvvvvvvvvvvv
		.filter( p -> p.startsWith("A"))  // p -> p[0]=="A" NO,
										  // p -> p.charAt(0)=='A' 
		.forEach( p -> System.out.println(p) );
				   //  ^^^^^^^^^^^^^^^^^^^^^

		// con un ciclo
		
		for(String p : parole) {
			/// vvvvvvvvvvvvvvvvv
			if( p.startsWith("A") ) {
			//if( p.charAt(0)=='A' ) {
				System.out.println(p);
			//  ^^^^^^^^^^^^^^^^^^^^^
			}
		}
		
		// lo stream fa qualcosa di simile a:
		Predicate<String> filtro = p -> p.startsWith("A");
		for(String p : parole) {
			if( filtro.test(p) ) {
				System.out.println(p);
			}
		}


		// FILTRARE le parole che iniziano con "A"
		System.out.println("------- FILTER + DISTINCT ------ ");
		Stream.of(parole)					// prendo le parole
		.filter( p -> p.startsWith("A"))	// selezione quelle che iniziano per "A"
		.distinct()							// scarto i duplicati
		.forEach( p -> System.out.println(p) ); // le stampo

		// con un ciclo
		Set<String> duplicati = new HashSet<String>();
		for(String p : parole) {
			if( p.startsWith("A") ) {
				if( ! duplicati.contains(p) ) {
					System.out.println(p);
					duplicati.add(p);
				}
			}
		}
	
		// FILTRARE le parole che iniziano con "A"
		System.out.println("------- FILTER + DISTINCT + LIMIT ------ ");
		Stream.of(parole)					// prendo le parole
		.filter( p -> p.startsWith("A"))	// selezione quelle che iniziano per "A"
		.distinct()							// scarto i duplicati
		.limit(2)                          // prendere sole le prime 10
		.forEach( p -> System.out.println(p) ); // le stampo

		// con un ciclo
		duplicati = new HashSet<String>();
		int contatore = 0;
		for(String p : parole) {
			if( p.startsWith("A") ) {
				if( ! duplicati.contains(p) ) {
					System.out.println(p);
					if( ++contatore == 2 ) {
						break;
					}
					duplicati.add(p);
				}
			}
		}

		// FILTRARE le parole che iniziano con "A"
		System.out.println("------- FILTER + DISTINCT + MAP ------ ");
		Stream.of(parole)					// prendo le parole
		.filter( p -> p.startsWith("A"))	// selezione quelle che iniziano per "A"
		.distinct()							// scarto i duplicati
		.map( p -> p.toUpperCase() )
		   // OPPURE
		.map( String::toUpperCase )
		.forEach( p -> System.out.println(p) ); // le stampo

		
		
		// Stampare la lunghezza delle parole
		System.out.println("------- lunghezze MAP ------ ");
		Stream.of(parole)						// prendo le parole
		.distinct()
		.map( p -> p.length() )					// calcolo la lunghezza
		.filter( l -> l>0)
		.sorted()
		.forEach( l -> System.out.println(l) ); // la stampo

		
		// Stampare la lunghezza delle parole
		System.out.println("------- lunghezze MAP decrescente ------ ");
		Stream.of(parole)						// prendo le parole
		.distinct()
		.map( p -> p.length() )					// calcolo la lunghezza
		.filter( l -> l>0)
		.sorted(Comparator.reverseOrder())  // ordinamento inverso a quello naturale degli Integer
				// OPPURE
		.sorted( (l1,l2) -> l2 - l1 )
		.limit(3)
		.forEach( l -> System.out.println(l) ); // la stampo

		
		// Stampare la lunghezza delle parole
		System.out.println("------- stringhe più lunghe ------ ");
		Stream.of(parole)						// prendo le parole
		.filter( p -> p.length() > 0)
		.distinct()
		.sorted( Comparator.comparingInt( String::length ).reversed() ) // ordino in base alla lunghezza delle stringhe
		.limit(3)
		.forEach( p -> System.out.println(p.length() + " : " + p) ); // la stampo

		class StrLen {
			public final String str;
			public final int len;
			StrLen(String str){
				this.str=str; this.len=str.length();
			}
		}
		
		Stream.of(parole)						// prendo le parole
		.filter( p -> p.length() > 0)
		.distinct()
		.map( p -> new StrLen(p) )
		.sorted( (a,b) -> b.str.compareTo(a.str) )
		.sorted( (a,b) -> b.len - a.len )
		.limit(3)
		.forEach( sl -> System.out.println(sl.len + " : " + sl.str) ); // la stampo
	
		//---------------------
		
		System.out.println("------- LA parola più lunga ------ ");
		Optional<String> piuLunga = 
		Stream.of(parole)						// prendo le parole
		.sorted( Comparator.comparingInt( String::length ).reversed() ) // ordino in base alla lunghezza delle stringhe
		.findFirst();
		
		System.out.println("Parola più lunga " + piuLunga.orElse("<nessuna parola trovata>"));
		
		piuLunga = 
		Stream.of(parole)						// prendo le parole
		.max( Comparator.comparingInt( String::length ) );
		
		System.out.println("Parola più lunga " + piuLunga.orElse("<nessuna parola trovata>"));

		// soltanto parole lunghissime
		piuLunga = 
		Stream.of(parole)						// prendo le parole
		.filter( p -> p.length() > 20 )
		.max( Comparator.comparingInt( String::length ) );
		
		System.out.println("Parola più lunga " + piuLunga.orElse("<nessuna parola trovata>"));
		if( piuLunga.isPresent() ) {
		  System.out.println("Parola più lunga " + piuLunga.get());
		}

	}
}
