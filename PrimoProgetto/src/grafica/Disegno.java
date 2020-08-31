package grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Disegno extends JFrame {

	public Disegno() {
		setTitle("Esempio disegno diretto");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Thread t = new Thread(()-> {
			while(true) {
				repaint();
				i+=10;
				if(i>255) i = 0;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					break;
				}
			}
		});
		t.start();
	}
	
	int i=0;
	@Override
	public void paint(Graphics g) {
		Rectangle dimensioni = g.getClipBounds();
		//System.out.println("Dimensione: " + dimensioni);
		g.setColor(Color.CYAN);
		g.drawLine(0, 0, 200, 200);
		g.drawRect(200, 200, 200, 100);
		
		g.setColor(new Color(196,66,12)); // RGB con valori da 0 a 155
		g.fillOval(300, 100, 200, 100);
		
		g.setColor(Color.pink);
		g.fillRoundRect(10, 200, 150, 150, 10, 5);
		
		g.setColor(new Color(i,i,i));
		g.fillRect(400, 400, 100, 100);
	}
	
	public static void main(String[] args) {
		new Disegno();
	}

}
