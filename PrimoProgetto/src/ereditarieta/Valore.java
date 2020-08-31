package ereditarieta;

public class Valore extends Espressione {

	private double valore;
	
	public Valore(double valore) {
		this.valore = valore;
	}
	
	@Override
	public double valore() {
		return valore;
	}
	
	@Override
	public String toString() {
		return String.valueOf(valore);
	}
}
