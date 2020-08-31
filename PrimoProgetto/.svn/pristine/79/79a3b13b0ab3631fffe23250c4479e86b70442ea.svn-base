package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class EsempiIO {

	static final int EOF = -1;
	public static void main(String[] args) throws IOException {
		
		Reader r = null;  
		// devo creare un Reader connsso al file "esempio.txt"
		r = new FileReader("dati/esempio.txt");
		
		int ch = r.read();
		
		// 0x00 00 xx xx ==> ch assumer valore tra 0x00000000 e 0x0000ffff
		// 0xff ff ff ff (-1) per indicare la fine del file
		
		if( ch == EOF ) {
			System.out.println("Fine file!");
		}
		
		char carattere = (char) ch; // 0x00 00 xx xx ==> 0xx xx 
		
		System.out.println("Letto: " + carattere);
		r.close();
		
		///--------------
		// "C:\MioDisco\Prove\Pippo\dati\esempio.txt"
		r = new FileReader("dati/esempio.txt");
		
		while( (ch=r.read()) != EOF ) {
			System.out.print((char)ch);
		}
		r.close();
		
		//----- oppure a blocchi
		r = new FileReader("dati/esempio.txt");
		char[] blocco=new char[4];
		int n;
		
		while( (n = r.read(blocco)) != EOF ) {
			String s = new String(blocco,0,n);
			System.out.print("(" + n + ")[" + s + "]");
		}
		r.close();
		
		SimilReaderDiStringa sr = new SimilReaderDiStringa("Hello world!\n");
		
		while( (ch=sr.read()) != EOF ) {
			System.out.print((char)ch);
		}
		
		//--------

		Writer w = new FileWriter("nuovo.txt");
		
		w.write("Questo è il contenuto del novo file!!");
		// gearchia di memorie
		
		w.flush();   // lo uso se poi devo ancora scrivere
		
		
		r = new FileReader("dati/esempio.txt");		
		while( (n = r.read(blocco)) != EOF ) {
			//String s = new String(blocco,0,n);
			//System.out.print("(" + n + ")[" + s + "]");
			w.write(blocco,0,n);
		}
		
		r.close();

		
		w.close();

	}
	
	
	static class SimilReaderDiStringa {
		private String contenuto;
		private int posizione=0;
		SimilReaderDiStringa(String s){
			contenuto=s;
		}
		public int read() {
			if( posizione >= contenuto.length()) {
				return -1;
			}
			int risultato = contenuto.charAt(posizione);
			posizione+=1;
			return risultato;
		}
	}

}
