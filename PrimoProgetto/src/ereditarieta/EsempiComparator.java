package ereditarieta;

public class EsempiComparator {
	
	interface I {
		int m();
	}
	
	static int statica=55;
	public static void main(String[] args) {
		final int locale = 5;
		
		// I x = new I();  // non posso istanziare un'interfaccia
		
		
		
		I obj = new I() {
			public int m() {
				statica++;
				return locale+statica;
			}
		};
		// EQUIVALE (circa) A:
		class ANONIMA implements I{
			public int m() {
				statica++;
				return locale+statica;
			}
		}
		I obj1 = new ANONIMA();
		
		
		
		
		System.out.println(obj.m());
		
		//locale = 42;
		
		System.out.println(obj.m()); // ??
		
		
		I costruito = costruisciOggetto();
		System.out.println(costruito.m());
	}
	
	public static I costruisciOggetto() {
		int j = 6;
		return new I() {
			public int m() {
				return j;
			}
		};
		// EQUIVALE (circa) A:
//		class ANONIMA2 implements I{
//			public int m() {
//				return j; // sosituito dal valore 6
//			}
//		}
		//I obj = new ANONIMA2();
		// return obj;

	}
	
	
}
