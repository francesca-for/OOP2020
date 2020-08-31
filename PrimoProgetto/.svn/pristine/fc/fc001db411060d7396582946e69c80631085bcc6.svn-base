package ereditarieta;

import static ereditarieta.Espressione.*;

public class EspressioniAritmetiche {

	public static void main(String[] args) {
		
//		Espressione x = new Espressione();  // vietato perchè classe astratta
//		x.value(); // non esiste in Espressione un'implementazione di valore()
		
		Espressione e = prodotto( 4 , somma( 3 , 2 ));
		
		System.out.println(e.toString() + " = " + e.valore() );
		
		verificaUguglianza(e.valore(), 20.0);
		
		// 4.0 * ( 3.0 + 2.0 ) = 20.0

		// senza i metodi statici
		
		e = new Operazione('*',new Valore(4),new Operazione('+',new Valore(3),new Valore(2)));
		
		verificaUguglianza(e.valore(), 20.0);
		
		verificaUguglianza(prodotto(7,6).valore(), 40.0);
		
	}
	
	public static boolean verificaUguglianza(double effettivo, double atteso) {
		if( effettivo == atteso ) {
			System.out.println("OK");
			return true;
		}else {
			System.err.println("Errore: mi aspettavo " + atteso + " ma ho ottenuto " + effettivo );
			return false;
		}
	}

}
