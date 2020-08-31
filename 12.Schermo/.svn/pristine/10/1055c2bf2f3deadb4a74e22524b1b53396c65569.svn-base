package it.polito.po.disegno.base;

public class Rettangolo implements Figura {

	private char daStampare;
	private int l, h;
	
	public Rettangolo(int l, int h, char daStampare) {
		super();
		this.daStampare = daStampare;
		this.l = l;
		this.h = h;
	}

	@Override
	public void disegna(Schermo s) {
		int maxW = s.getMaxWidth();
		int maxL = s.getMaxLength();
		
		Coordinata c = s.getPuntoPartenza(this);
		int x = c.getX();
		int y = c.getY();
		
		for(int i=0; i<h; i++)
		{	
			if(x+i>=maxW) break;
			for(int j=0; j<l; j++)
			{	
				if(y+j>=maxL) break;
				s.stampaPunto(x+i, y+j,	daStampare);
			}
		}
	}

}
