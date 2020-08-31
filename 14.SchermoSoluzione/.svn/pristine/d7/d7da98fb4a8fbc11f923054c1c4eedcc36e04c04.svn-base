package it.polito.po.disegno.base;

import it.polito.po.disegno.base.Figura;

public class Triangolo implements Figura {
	private char daStampare;
	private final int l;
	private final int h;
	
	public Triangolo(int h, int l, char daStampare) {
		this.daStampare=daStampare;
		this.h = h;
		this.l = l;
	}

	@Override
	public void disegna(Schermo s) {
		
		int maxW = s.getMaxWidth();
		int maxL = s.getMaxLenght();
		
		Coordinata p = s.getPuntoPartenza(this);
		int x = p.getX();
		int y = p.getY();
		
		float lastJ = l;
		for (int i = 0; i < h; i++) {
			if(x+i>=maxW) break;
			
			if(i==h-1)
				lastJ=1;
			
			for (int j = 0; j < Math.round(lastJ); j++) {
				if(y+j >= maxL) break;
				s.stampaPunto(x+i, y+j, daStampare);
			}
			
			lastJ-=((float)l-1)/((float)h-1);
		}

	}
	
}
