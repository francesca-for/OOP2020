package it.polito.po.disegno.base;

import java.util.LinkedList;
import java.util.List;

import it.polito.po.disegno.exceptions.FiguraFuoriSchermoException;
import it.polito.po.disegno.exceptions.TroppeFigureException;

public class Schermo {
	
	private final static char C_SFONDO = '.';
//	private final static int MAX_FIGURE = 100; 
	
	private char[][] schermo;
	private int maxWidth,maxLength;
	
//	FiguraSuSchermo[] lista_figure;
	List<FiguraSuSchermo> lista_figure;
//	int next;
	
	public Schermo(int maxWidth, int maxLength) {
		this.maxWidth = maxWidth;
		this.maxLength = maxLength;
		
		schermo = new char[maxWidth][maxLength];
		init_schermo();
		
//		lista_figure = new FiguraSuSchermo[MAX_FIGURE];
		lista_figure = new LinkedList<FiguraSuSchermo>();
//		next = 0;
	}
	

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void init_schermo() {
		for (int i=0; i<maxWidth; i++)
			for(int j=0; j<maxLength; j++)
				schermo[i][j] = C_SFONDO;
	}
	
	public Coordinata getPuntoPartenza(Figura figura)
	{
		Coordinata res = null;
		
		for(FiguraSuSchermo f : lista_figure)
		{
//			if(f==null)
//				break;
			if(f.getFigura().equals(figura))
				res = f.getCoordinata();
		}
		
		return res;
	}
	
	public void disegna(Figura figura,
						Coordinata puntoPartenza)
				throws FiguraFuoriSchermoException { 
//						,TroppeFigureException {
		if(puntoPartenza.getX()>=maxWidth ||
				puntoPartenza.getY()>=maxLength)
			throw new FiguraFuoriSchermoException();
//		if(next<MAX_FIGURE)
//			lista_figure[next++] = 
		lista_figure.add(
			new FiguraSuSchermo(figura, puntoPartenza));
//		else
//			throw new TroppeFigureException();
	}

	public void stampaPunto(int x, int y, char c)
	{
		if(c==C_SFONDO)
			c='*';
		schermo[x][y] = c;
	}
	
	public void visualizza()
	{
		for(FiguraSuSchermo f: lista_figure)
		{
//			if(f==null)
//				break;
			f.getFigura().disegna(this);
		}
		
		for (int i=0; i<maxWidth; i++)
		{
			for(int j=0; j<maxLength; j++)
			{
				System.out.print(schermo[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	class FiguraSuSchermo {
		Figura figura;
		Coordinata coordinata;
		public FiguraSuSchermo(Figura figura, Coordinata coordinata) {
			super();
			this.figura = figura;
			this.coordinata = coordinata;
		}
		
		public Figura getFigura() {
			return figura;
		}
		
		public Coordinata getCoordinata() {
			return coordinata;
		}
	}
}
