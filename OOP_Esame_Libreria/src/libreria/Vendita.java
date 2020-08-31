package libreria;

public class Vendita {
	private int settimana;
	private int mese;
	private int copieVendute = 1;

	public Vendita(int settimana, int mese) {
		this.settimana = settimana;
		this.mese = mese;
	}

	public int getSettimana() {
		return settimana;
	}

	public int getMese() {
		return mese;
	}
	
	public int getCopieVendute() {
		return copieVendute;
	}
	
	public void aggiornaCopieVendute() {
		this.copieVendute++;
	}
}
