package ereditarieta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;


public class EsempiComp {
	
	static class Studente implements Comparable {
		int matricola;
		String nome;
		String cognome;
		Studente(int matricola, String nome, String cognome) {
			this.matricola = matricola;
			this.nome = nome;
			this.cognome = cognome;
		}
		@Override
		public int compareTo(Object o) {  // definisce l'ordinamento naturale
			return this.matricola - ((Studente)o).matricola;
		}
		@Override
		public String toString() {
			return matricola + " : " + cognome + ", " + nome;
		}
		public String getCognome() { return cognome; }
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Studente[] classe = {
			new Studente(100,"Mario","Rossi"),
			new Studente(110,"Giuseppe","Bianchi"),
			new Studente(105,"Filippo","Neri"),
			new Studente(107,"Giorgio","Verdi")
		};
		
		System.out.println("Prima: " + Arrays.toString(classe));
		Arrays.sort(classe);  // ordinamento naturale --> Comparable
		System.out.println("Dopo : " + Arrays.toString(classe));
		
		Arrays.sort(classe, new Comparator() {
			public int compare(Object a, Object b) {
				return ((Studente)a).cognome.compareTo( ((Studente)b).cognome );
			}
		});
		// OPPURE con una lambda
		Arrays.sort(classe, ( a,  b) ->
				((Studente)a).cognome.compareTo( ((Studente)b).cognome )
		);
		System.out.println("Dopo : " + Arrays.toString(classe));

		
		Comparator comparatoreAlfabetico = new Comparator() {
			public int compare(Object a, Object b) {
				Studente primo = (Studente)a;
				Studente secondo = (Studente)b;
				int confrontoCognomi = primo.cognome.compareTo(secondo.cognome);
				
				if(confrontoCognomi != 0) return confrontoCognomi;
				
				return primo.nome.compareTo(secondo.nome);
			}
		};
		Arrays.sort(classe, comparatoreAlfabetico);
		
		// ESERCIZIO: estendere il comparatore in modo che in caso di omonimia
		//			  l'ordinamento segua le matricole

		// ----------------------
		
		EstrattoreDiAttributo estraiCognome = new EstrattoreDiAttributo() {
			public Comparable estrai(Object o) {
				return ((Studente)o).cognome;
			}
		};
		
		Comparable cognome = estraiCognome.estrai(classe[0]);
		cognome.compareTo("ABACO");
		
		Comparator perCognome = confrontaInBaseA(estraiCognome);
		
		Arrays.sort(classe,perCognome);
		
		// OPPURE
		
		Arrays.sort(classe, 
				confrontaInBaseA( new EstrattoreDiAttributo(){
					public Comparable estrai(Object o) {
						return ((Studente)o).cognome;
					}
				}));
		
		// OPPURE usando i metodi già definiti in Comparator
		Arrays.sort(classe, Comparator.comparing(new Function() {
			@Override
			public Object apply(Object o) {
				int perCongome=1;
				return ((Studente)o).cognome;
			}			
		}));
		
		// OPPURE usando una lambda
		
		Arrays.sort(classe, Comparator.comparing( o -> ((Studente)o).cognome ));
	
		// OPPURE con un method reference
		
		Arrays.sort(classe, Comparator.comparing( Studente::getCognome ));
		
	}
	
	interface EstrattoreDiAttributo {
		Comparable estrai(Object o);
	}
	
	static Comparator confrontaInBaseA(EstrattoreDiAttributo estrattore) {
		return new Comparator() {
			public int compare(Object a, Object b) {
				Comparable attrA = estrattore.estrai(a);
				Comparable attrB = estrattore.estrai(b);
				return attrA.compareTo(attrB);
			}
		};
	}

}
