package stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.stream.Stream;
import static java.lang.System.*;


public class EsempiCollectors {

	public static void main(String[] args) {
		String[] parole = data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ \n.\",]+");
		
		String risultato = 
		Stream.of(parole)
			.reduce( (risultatoIntermedio , elemento) -> risultatoIntermedio + " " + elemento )
			.orElse("--nessuna parola--")
			;
		out.println(risultato);
		
		risultato = 
		Stream.of(parole)
			.reduce("Testo: ",
					(risultatoIntermedio , elemento) -> risultatoIntermedio + " " + elemento )
			;
		out.println(risultato);

		int caratteri=
		Stream.of(parole)
			.parallel()
			.map( p -> p.length())
			.reduce( (vi, e) -> vi + e)
			.orElse(-1);
			;
		out.println(caratteri);
		
		// COLLECT
		out.println("COLLECTOR");
		risultato = 
		Stream.of(parole)  // tipo = Stream<String>
			.collect( StringBuffer::new, // supplier: chiamato per costruire il contenitore
										 // tipo = StringBuffer
					  ( sb, p ) -> sb.append(' ').append(p), // accumulator: accumula elementi nel contenitore
					  ( sb1, sb2 ) -> sb1.append(' ').append(sb2)  // combiner: combina due contenitori
//					  ( sb1, sb2 ) -> {}  // combiner che bara e non fa nulla....
					).toString();
		out.println(risultato);
		
		risultato = 
		Stream.of(parole)  // tipo = Stream<String>
			.collect( StringBuffer::new, // supplier: chiamato per costruire il contenitore
										 // tipo = StringBuffer
					  (StringBuffer sb, String p ) -> sb.append(' ').append(p), // accumulator: accumula elementi nel contenitore
					  (StringBuffer sb1, StringBuffer sb2 ) -> sb1.append(' ').append(sb2)  // combiner: combina due contenitori
//					  ( sb1, sb2 ) -> {}  // combiner che bara e non fa nulla....
					).toString();

		LinkedList words = 
		Stream.of(parole)  // tipo = Stream<String>
			.collect( LinkedList::new,
					  ( l , e ) -> l.add(e),
					  ( l1, l2 ) -> l1.addAll(l2)
					);
		out.println(words);
		
		words = 
		Stream.of(parole)  // tipo = Stream<String>
			.map( String::toUpperCase )
			.sorted()
			.collect( LinkedList::new,
					  ( l , e ) -> l.add(e),
					  ( l1, l2 ) -> l1.addAll(l2)
					);
		out.println(words);
		
		LinkedList lw = new LinkedList();
		Stream.of(parole).forEach( p -> lw.add(p));
		
		List<String> l =
		Stream.of(parole).collect( toList() );
		
		// per concatenare in una stringa
		risultato = 
				Stream.of(parole).collect( joining(" ") );
		// EQUIVALENTE A
		risultato = 
		Stream.of(parole)  
			.collect( StringBuffer::new, 
					  (StringBuffer sb, String p ) -> sb.append(' ').append(p), 
					  (StringBuffer sb1, StringBuffer sb2 ) -> sb1.append(' ').append(sb2) 
					).toString();

		
		// per accumulare in un contenitore specifico
		words = Stream.of(parole).collect(toCollection(LinkedList::new));
		
		// GROUPING BY
		out.println("---------- GROUPING_BY -----------");
		Map<Character,List<String>> perIniziale = 
		Stream.of(parole)
			.filter( p -> p.length() > 0)
			.collect(groupingBy( p -> p.charAt(0) ));
		
		out.println( perIniziale );
		
		perIniziale =
		Stream.of(parole)
		.filter( p -> p.length() > 0)
		.collect(groupingBy( 
					p -> p.charAt(0), // classifier (determina il tipo della chiava
					HashMap::new,     // supplier
					toList()		  // downstream
				));
		
		Map<Character,String> perInizialeStr =
				Stream.of(parole)
				.filter( p -> p.length() > 0)
				.distinct()
				.sorted( (p1,p2) -> p1.compareToIgnoreCase(p2) )
				.collect(groupingBy( 
							p -> Character.toUpperCase(p.charAt(0)), // classifier (determina il tipo della chiave)
							HashMap::new,     // supplier
//							() -> new HashMap<Character,String>(),
							joining("\n\t","\n\t","\n")		  // downstream (determina it tipo del valore)
						));
		out.println(perInizialeStr);
		
		// ESERCIZIO: provare a riscrivere l'espressione di prima utilzzando solo cicli e 
		// 			  elementi del framework delle collezioni

		
		//-------------------------
		
		Set<Map.Entry<Character,String>> entries = perInizialeStr.entrySet();
		
		for( Map.Entry<Character,String> e : entries) {
			out.println("Chiave " + e.getKey() + " --> Valore con lunghezza " + e.getValue().length());
		}
	}

}
