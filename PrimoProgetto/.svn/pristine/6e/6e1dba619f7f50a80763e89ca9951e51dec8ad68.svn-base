package collezioni;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Esercizio {
	
	// https://oop.polito.it/svn/OOP2020/ITA1/

	/**
	 * Elencare tutte le parole di un testo
	 * raggruppate per lunghezza (# caratteri)
	 * a poi in ordine alfabetico.
	 * 
	 * 1) Utilizzare un comparatore
	 * 2) Utilizzare una Mappa lunghezza -> lista delle parole con quella lunghezza
	 * 
	 *   Output atteso:
	 * """  
	 * Lunghezza 3
	 * Est
	 * ....
	 * Lunghezza 4:
	 * Alla
	 * ...	
	 * """
	 */
	public static void main(String[] args) {
		String[] parole = data.Lyrics.ALL_ALONG_THE_WATCHTOWER.split("[ \n\",]+");
//		for(String p : parole) {
//			System.out.println(p);
//		}
//		
//		Arrays.sort(parole, (p1,p2) -> {
//			int diffLunghezza = p1.length() - p2.length();
//			if(diffLunghezza != 0 ) return diffLunghezza;
//			return p1.compareTo(p2);
//		}); 
//		
//		Arrays.sort(parole,Comparator.comparingInt(String::length).
//									  thenComparing(Comparator.naturalOrder()));
//
//		for(String p : parole) {
//			System.out.println(p);
//		}
		
		Map<Integer, List<String>> mappaLunghezzaParole = new TreeMap<>();
		for(String p : parole) {
			int l = p.length();
			List<String> stessaLunghezza;
			if( ! mappaLunghezzaParole.containsKey( l )) {
				stessaLunghezza = new LinkedList<>();
				mappaLunghezzaParole.put( l , stessaLunghezza );
			}else {
				stessaLunghezza = mappaLunghezzaParole.get( l );
			}
			stessaLunghezza.add(p);
		}
		
		
//		for(int i=1; i<15; ++i) {
//			System.out.println("Lunghezza " + i);
//			List<String> stessaLunghezza = mappaLunghezzaParole.get(i);
//			if( stessaLunghezza == null) {
//				System.out.println("-- nessuna parola");
//			}else {
//				Collections.sort(stessaLunghezza);
//				for(String p : stessaLunghezza) {
//					System.out.println(p);
//				}
//			}
//		}
		for( int l : mappaLunghezzaParole.keySet() ) {
			System.out.println("Lunghezza " + l);
			List<String> stessaLunghezza = mappaLunghezzaParole.get(l);
			Collections.sort(stessaLunghezza);
			// OPPURE
			stessaLunghezza.sort( Comparator.naturalOrder() );
			for(String p : stessaLunghezza) {
				System.out.println(p);
			}
		}
		
		System.out.println(mappaLunghezzaParole.get(10));
		
		Map<Integer, SortedSet<String>> mappaNoDup = new TreeMap<>();
		for(String p : parole) {
			int l = p.length();
			SortedSet<String> stessaLunghezza;
			if( ! mappaNoDup.containsKey( l )) {
				stessaLunghezza = new TreeSet<>( );
				mappaNoDup.put( l , stessaLunghezza );
			}else {
				stessaLunghezza = mappaNoDup.get( l );
			}
			stessaLunghezza.add(p);
		}
		for( int l : mappaNoDup.keySet() ) {
			System.out.println("Lunghezza " + l);
			SortedSet<String> stessaLunghezza = mappaNoDup.get(l);
			for(String p : stessaLunghezza) {
				System.out.println(p);
			}
		}
		System.out.println(mappaNoDup.get(10));

	}

}
