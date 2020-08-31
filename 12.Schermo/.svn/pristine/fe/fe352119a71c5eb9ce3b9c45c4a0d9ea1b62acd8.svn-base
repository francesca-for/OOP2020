package it.polito.po.disegno.base;

import it.polito.po.disegno.exceptions.CoordinataNegativaException;

public class Coordinata {

	private int x, y;

	public Coordinata(int x, int y) throws CoordinataNegativaException {
		super();
		if(x<0 || y<0)
			throw new CoordinataNegativaException();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
