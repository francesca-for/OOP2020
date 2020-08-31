package ereditarieta;

public abstract class Espressione {
	
	/**
	 * Calcola il prodotto di un valore per un'espressione
	 * 
	 * @param a valore
	 * @param b espressione
	 * @return l'oggetto espressione che rappresenta il prodotto
	 */
	public static Espressione prodotto(double a, Espressione b) {
		Valore sinistra = new Valore(a);
		return new Operazione('*',sinistra,b);
	}
	
	public static Espressione prodotto(Espressione a, double b) {
		Valore destra = new Valore(b);
		return new Operazione('*',a,destra);
	}
	
	public static Espressione prodotto(double a, double b) {
		Valore sinistra = new Valore(a);
		Valore destra = new Valore(b);
		return new Operazione('*',sinistra,destra);
	}

	public static Espressione prodotto(Espressione a, Espressione b) {
		return new Operazione('*',a,b);
	}

	
	/**
	 * Calcola la somma di due valori
	 * 
	 * @param a primo valore
	 * @param b secondo valore
	 * @return l'oggetto espressione che rappresenta la somma
	 */
	public static Espressione somma( double a , double b) {
		Valore sinistra = new Valore(a);
		Valore destra = new Valore(b);
		return new Operazione('+',sinistra,destra);
	}

	public static Espressione somma( Espressione a , double b) {
		Valore destra = new Valore(b);
		return new Operazione('+',a,destra);
	}

	public static Espressione somma( double a , Espressione b) {
		Valore sinistra = new Valore(a);
		return new Operazione('+',sinistra,b);
	}

	public static Espressione somma( Espressione a , Espressione b) {
		return new Operazione('+',a,b);
	}

	public abstract double valore() ; /*{
		// TODO Auto-generated method stub
		System.err.println("Attenzione il metodo valore dovrebbe essere ridefinito (overridden)");
		return 0.0;
	}*/
	
	public abstract String toString() ; /*{
		return "";
	}*/

}
