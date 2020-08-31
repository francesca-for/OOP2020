package it.polito.po.disegno;

import it.polito.po.disegno.base.Coordinata;
import it.polito.po.disegno.base.Figura;
import it.polito.po.disegno.base.Gruppo;
import it.polito.po.disegno.base.Punto;
import it.polito.po.disegno.base.Quadrato;
import it.polito.po.disegno.base.Rettangolo;
import it.polito.po.disegno.base.Schermo;
import it.polito.po.disegno.base.Triangolo;

public class Esempio {
	
	public static void main(String[] args) {
		try {
			
			
			Schermo s = new Schermo(10,30);
			
			//polimorfismo
			Punto p1 = new Punto('*');
			Figura p2 = new Punto('+');
			s.disegna(p1, new Coordinata(6,24));
			s.disegna(p2, new Coordinata(7,7));
			
			
			Rettangolo r1 = new Rettangolo(3,3,'x');
			Figura r2 = new Rettangolo(3,2,'a');
			Figura r3 = new Rettangolo(4,4,'o');
			s.disegna(r1, new Coordinata(3,8));
			s.disegna(r2, new Coordinata(0,0));
			s.disegna(r3, new Coordinata(1,1));
			
			//visualizza punto 1
			s.visualizza();
			
			s = new Schermo(10,30);		
			System.out.println();
			Triangolo t1 = new Triangolo(5, 7, 't');

			s.disegna(t1, new Coordinata(1, 1));
			
			Rettangolo q1 = new Quadrato(3, 'q');
			Quadrato q2 = new Quadrato(5, 'q');
			 
			s.disegna(q1, new Coordinata(2, 9));
			//q2 disegnato parzialmente, ultima riga va fuori da schermo
			s.disegna(q2, new Coordinata(7, 9));
			s.disegna(r3, new Coordinata(3,20));
			
			//visualizza punto 2
			s.visualizza();
			System.out.println();
			
			s = new Schermo(10,30);	
			// trapezio come gruppo: rettangolo+triangolo
			// si potrebbe fare una classe TrapezioRettangolo che implementi FiguraComposita
			// con base minore, base maggiore e altezza come parametri
			Gruppo trapezioRettangolo = new Gruppo();
			Rettangolo rTrapezio = new Rettangolo(3,5,'T');
			Triangolo tTrapezio = new Triangolo(3,6,'t');
			trapezioRettangolo.aggiungi(rTrapezio, 0, 0);
			trapezioRettangolo.aggiungi(tTrapezio, 0, 5);
			s.disegna(trapezioRettangolo, new Coordinata(5,5));
			
			//visualizza punto 3
			s.visualizza();
			System.out.println();
						
			//secondo schermo più piccolo: le stesse figure possono coesistere su più schermi 
			Schermo s2 = new Schermo(7,7);
			s2.disegna(p1, new Coordinata(1, 1));
			s2.disegna(r2, new Coordinata(2,2));
			
			s2.visualizza();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
