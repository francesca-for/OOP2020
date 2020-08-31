package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 
 * 
 * TODO:
 * 
 * - aggiornamento dei dati da mostrare (occorre chiamare repaint() per aggiornare)
 * - lettura dei dati da un file di testo
 * - aggiungere un titolo al grafico
 * - aggiungere un asse (orizzontale al grafico)
 * - aggiungere una griglia di riferimento
 *
 */
public class EsempioDiagramma extends JFrame {
	String[] etichette = {"Primo","Secondo","Terzo","Quarto","Quinto"};
	int[] valori = {4,3,7,1,5};
	
	static class Diagramma extends JComponent {
		private static final int MARGINE_SUP = 10;
		private static final int MARGINE_SX = 10;
		private static final int SPAZIATURA_ETICHETTA = 5;
		String[] etichette;
		int[] valori;
		
		Diagramma(String[] e, int[] v){
			this.etichette=e;
			this.valori=v;
		}
		
		@Override
		public void paint(Graphics g) {
			// dimensione area da disegnare
			Rectangle dim = g.getClipBounds();
			// valore massimo da rappresentare
			int max = 0;
			for(int v : valori) max = (v>max?v:max);
			
			// fattore di scala dipende da: valore massimo e dimensione dell'area disponibile
			double fattoreDiScala =  (dim.width - MARGINE_SX*2) / (double)max;
			// lo spessore delle barre dipende da numero della barre e dimensione disponibile
			int intervallo = (dim.height - MARGINE_SUP*2)/valori.length;
			int spessore = (int)(0.8 * intervallo); // dipende dall'intervallo
			
			// si disegnano tutte le barre
			for(int i=0; i<valori.length; ++i) {
				g.setColor(Color.ORANGE);  // colore della barra
				g.fillRect(MARGINE_SX, intervallo*i+MARGINE_SUP,         // posizione
						   (int)(valori[i] * fattoreDiScala), spessore); // dimensioni
				
				g.setColor(Color.BLACK);  // colore dell'etichetta
				g.drawString(etichette[i], 									// etichetta
							  MARGINE_SX + SPAZIATURA_ETICHETTA,   			// posizione x
							  intervallo*i+(int)(spessore*0.75)+MARGINE_SUP); // posizione y
			}
		}
	}
	
	public EsempioDiagramma() {
		setTitle("Esempio diagramma");
		setSize(800,500);
		
		Diagramma d = new Diagramma(etichette,valori);
		setLayout(new BorderLayout());
		add(d,BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new EsempioDiagramma();
	}

}
