package it.polito.po.disegno;

import it.polito.po.disegno.base.Coordinata;
import it.polito.po.disegno.base.Figura;
import it.polito.po.disegno.base.Punto;
import it.polito.po.disegno.base.Rettangolo;
//import it.polito.po.disegno.base.Rettangolo;
import it.polito.po.disegno.base.Schermo;
import it.polito.po.disegno.exceptions.CoordinataNegativaException;
import it.polito.po.disegno.exceptions.FiguraFuoriSchermoException;
import it.polito.po.disegno.exceptions.TroppeFigureException;
//import it.polito.po.disegno.exceptions.CoordinataNegativaException;
//import it.polito.po.disegno.exceptions.FiguraFuoriSchermoException;
//import it.polito.po.disegno.exceptions.TroppeFigureException;

public class Esempio {

	public static void main(String[] args) throws FiguraFuoriSchermoException, TroppeFigureException, CoordinataNegativaException /*throws TroppeFigureException, FiguraFuoriSchermoException, CoordinataNegativaException */{
		
		Schermo s = new Schermo(10,30);
		s.visualizza();
		
//		NON RISPETTA I REQUISITI
//		s.stampaPunto(6, 24, '*');
//		s.stampaPunto(7, 7, '+');
//		s.visualizza();
		
//		try {
//			s.disegna(null, null);
//		} catch (TroppeFigureException | FiguraFuoriSchermoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//		}
	
		Punto p1 = new Punto('*');
		Figura p2 = new Punto('+');
		s.disegna(p1, new Coordinata(6,24));
		s.disegna(p2, new Coordinata(7,7));
//		
//		
		Rettangolo r1 = new Rettangolo(3,3,'x');
		Figura r2 = new Rettangolo(2,3,'a');
		Figura r3 = new Rettangolo(4,4,'o');
		s.disegna(r1, new Coordinata(3,8));
		s.disegna(r2, new Coordinata(0,0));
		s.disegna(r3, new Coordinata(1,1));
//		
//		
		s.visualizza();
	}

}
