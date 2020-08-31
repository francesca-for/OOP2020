package it.polito.po.disegno.base;

public class Punto implements Figura {

	private char daStampare;
	
	public Punto(char daStampare) {
		super();
		this.daStampare = daStampare;
	}

	@Override
	public void disegna(Schermo s) {
		s.stampaPunto(s.getPuntoPartenza(this).getX(),
						s.getPuntoPartenza(this).getY(),
						daStampare);
	}

}
