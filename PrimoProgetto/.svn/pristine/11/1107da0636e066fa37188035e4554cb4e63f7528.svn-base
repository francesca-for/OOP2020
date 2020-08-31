package regexp;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class EsempiRegExp {

	public static void main(String[] args) {
		
		// [0-9] : un qualunque carattre da 0 a 9
		Pattern re = Pattern.compile("[0-9][0-9]:[0-9][0-9]");
		Matcher m = re.matcher("9:24");
		
		if( m.matches() ) {
			System.out.println("Riconosciuto!");
		}else {
			System.out.println("NON Riconosciuto!");
		}
		
		re = Pattern.compile("[0-9][0-9]?:[0-9][0-9]");
		m = re.matcher("9:24");
		if( m.matches() ) {
			System.out.println("Riconosciuto!");
		}else {
			System.out.println("NON Riconosciuto!");
		}
		
		// [0-9] equivale a \d
		re = Pattern.compile("\\d\\d?:\\d\\d");
		m = re.matcher("9:24");
		if( m.matches() ) {
			System.out.println("Riconosciuto!" + m.group());
		}else {
			System.out.println("NON Riconosciuto!");
		}

		re = Pattern.compile("[012]?[0-9]:[0-9][0-9]");
		m = re.matcher("32:24");
		if( m.matches() ) {
			System.out.println("Riconosciuto! " + m.group());
		}else {
			System.out.println("NON Riconosciuto!");
		}

		// le coppie di ( ) identificano dei gruppi di cattura
		//                          1             2
		//					   vvvvvvvvvvv   vvvvvvvvvv
		re = Pattern.compile("([012]?[0-9]):([0-9][0-9])");
		//                     ^^^^^^^^^^^ ^ ^^^^^^^^^^
		//                                  0
		m = re.matcher("12:24");
		if( m.matches() ) {
			System.out.println("Riconosciuto: " + m.group());
			System.out.println("       tutto: " + m.group(0));
			System.out.println("          hh: " + m.group(1));
			System.out.println("          mm: " + m.group(2));
			
			int hh = Integer.parseInt(m.group(1));
			int mm = Integer.parseInt(m.group(2));
			
			System.out.println("Ore: " + hh + ", minuti: " + mm);
		}else {
			System.out.println("NON Riconosciuto!");
		}

		// Es. 2020-05-25
		// [0-9][0-9]- [0-9-]
		Pattern data = Pattern.compile("(\\d{4}|\\d{2})-(\\d{2})-(\\d{2})");
		m = data.matcher("2020-05-25");
		if( m.matches() ) {
			System.out.println("Anno " + m.group(1));
			System.out.println("Mese " + m.group(2));
			System.out.println("Giorno " + m.group(3));
		}

		data = Pattern.compile("(\\d{2}(\\d{2})?)-(\\d{2})-(\\d{2})");
		//                              222222 
		//                       111111111111111   333333   444444
		m = data.matcher("20-05-25");
		if( m.matches() ) {
			System.out.println("Anno " + m.group(1));
			System.out.println("Mese " + m.group(3));
			System.out.println("Giorno " + m.group(4));
		}else {
			System.out.println("Non riconosciuto!");
		}

		// Non-capturing group 
		data = Pattern.compile("(\\d{2}(?:\\d{2})?)-(\\d{2})-(\\d{2})");
		//                              xxxxxxxx 
		//                       11111111111111111   222222   333333
		m = data.matcher("20-05-25");
		if( m.matches() ) {
			System.out.println("Anno " + m.group(1));
			System.out.println("Mese " + m.group(2));
			System.out.println("Giorno " + m.group(3));
		}else {
			System.out.println("Non riconosciuto!");
		}
		
		// FIND
		System.out.println("--------------");
		String s = "oggi: 2020-05-25, ieri: 2020-05-24";
		m = data.matcher(s);
		while( m.find() ) {
			System.out.println("Anno " + m.group(1));
			System.out.println("Mese " + m.group(2));
			System.out.println("Giorno " + m.group(3));			
		}
		
		System.out.println("--------------");
		String[] date = {"2020-05-25","2019-07-13","1945-01-01","2033/17/34"};
		final Pattern reData = Pattern.compile("(\\d{2}(?:\\d{2})?)-(\\d{2})-(\\d{2})");
		
		Stream.of(date)
		.filter( d -> reData.matcher(d).matches() )
		.forEach(System.out::println);

		Stream.of(date)
		.filter( reData.asPredicate() )
		.forEach(System.out::println);
		
		Predicate<String> dataCorretta = reData.asPredicate();
		
		Stream.of(date)
		.filter( dataCorretta )
		.forEach(System.out::println);
		
		// Scrivere espressione regolare per riconoscere
		// email valide del Politecnico di Torino (sia studenti che personale)
		//
		// es.
		//     marco.torchiano@polito.it
		//     s999999@studenti.polito.it
		//	   d00000@studenti.polito.it
		
		//Pattern emailPoli = Pattern.compile("(([sd][0-9]{4,6})|([A-Za-z.]+))@(studenti\\.)?polito\\.it");
		// [sd]  UGUALE s|d
		// [sd]\d  UGUALE a (s|d)\d   =!= s|d\d
//		Pattern emailPoli = Pattern.compile("([a-z]+\\.[a-z]+@polito\\.it)|([sd]\\d+@studenti\\.polito\\.it)",
//											Pattern.CASE_INSENSITIVE);
//										// [A-Za-z]+\\.[A-Za-Z]+
//		Pattern emailPoli = Pattern.compile("(([a-z]+\\.[a-z]+@)|([sd]\\d+@studenti\\.))polito\\.it",
//											 Pattern.CASE_INSENSITIVE);

		// \w è un word character ovvero [A-Za-z0-9_]
		String regExp = "((\\w(\\.\\w)*@)|([sd]\\d+@studenti\\.))polito\\.it";
		System.out.println("RegExp: " + regExp);
		Pattern emailPoli = Pattern.compile(regExp,Pattern.CASE_INSENSITIVE);
		
		String[] email = {"marco.torchiano@polito.it",
						  "marco.torchiano@studenti.polito.it",
						  "s999999@studenti.polito.it",
						  "d00000@studenti.polito.it"};
		
		Stream.of(email)
		.filter( emailPoli.asPredicate() )
		.forEach(System.out::println);

		
		// [a-z]+.[a-z] o [a-z]+.?[a-z]+? ==  [a-z]+.?[a-z]*
		//				   [a-z]+(.[a-z]+)*

		
		// look-behind
		Pattern host = Pattern.compile("(?<=@)(studenti\\.)?polito\\.it");
		
		m = host.matcher("d123@studenti.polito.it");
		if(m.find()) System.out.println(m.group());
		
		Pattern host1 = Pattern.compile("@(studenti\\.)?polito\\.it");
		
		m = host1.matcher("d123@studenti.polito.it");
		if(m.find()) System.out.println(m.group());
		
		// positive look-behind (?<=....)
		// positive look-ahead (?=....)
		// negative look-ahead (?!=....)

}
}
