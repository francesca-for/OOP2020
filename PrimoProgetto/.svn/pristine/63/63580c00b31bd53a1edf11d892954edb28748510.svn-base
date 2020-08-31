package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class EsempiStdIn {

	public static void main(String[] args) throws IOException {
		
//		int ch = System.in.read();
//		
//		if(ch!=-1) {
//			char carattere  = (char)ch;
//			System.out.println("Da tastiera: " + carattere);
//		}
		
//		Reader r = new InputStreamReader( System.in );
//					// Adapted da InputStream --> Reader
//
//		int ch = r.read();
//		char carattere  = (char)ch;
//		System.out.println("Da tastiera: " + carattere);
//		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		
		String linea = br.readLine();  // legge una riga (a-capo escluso)
		
		System.out.println("Linea letta da tastiera: " + linea);
		
		int totale=0;
		while(true) {
			String l = br.readLine();
			if(l.equals("FINE"))break;
			System.out.println(">" + l);
			int n = Integer.parseInt(l);
			totale += n;
			System.out.println("\tTotale: " + totale);
		}
	}

}
