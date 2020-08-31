package it.polito.po.disegno.base;

import it.polito.po.disegno.exceptions.CoordinataNegativaException;
import it.polito.po.disegno.exceptions.FiguraFuoriSchermoException;
import it.polito.po.disegno.exceptions.TroppeFigureException;

public interface FiguraComposita extends Figura {

	public abstract void registraComponenti(Schermo s) throws FiguraFuoriSchermoException, TroppeFigureException, CoordinataNegativaException;
	
	public abstract void aggiungi(Figura figura, int offsetx, int offsety) throws TroppeFigureException, CoordinataNegativaException;

}
