package ereditarieta;

public class Operazione extends Espressione {
	
	private char operatore; // + - * /
	
	private Espressione sinistra;
	private Espressione destra;
	
	Operazione(char operatore, Espressione sinistra, Espressione destra) {
		this.operatore = operatore;
		this.sinistra = sinistra;
		this.destra = destra;
	}
	
	@Override
	public double valore() {
		switch( operatore ) {
		case '+' : return sinistra.valore() + destra.valore();
		case '-' : return sinistra.valore() - destra.valore();
		case '*' : return sinistra.valore() * destra.valore();
		case '/' : return sinistra.valore() / destra.valore();
		}
		return -1;
	}
	
	@Override
	public String toString() {
		//return "(" + sinistra.toString() + ") " + operatore + " (" + destra.toString() + ")";
		String res="";
		if( sinistra instanceof Operazione ) {
			res += "(" + sinistra.toString() + ")";
		}else {
			res += sinistra.toString();
		}
		
		res += " " + operatore + " ";

		if( destra instanceof Operazione ) {
			res += "(" + destra.toString() + ")";
		}else {
			res += destra.toString();
		}
		
		return res;
}

}
