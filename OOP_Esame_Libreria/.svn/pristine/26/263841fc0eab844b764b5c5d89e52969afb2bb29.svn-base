package libreria;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Libro {
	private String titolo;
	private String autore;
	private int anno;
	private double prezzo;
	private Editore editore;
	private int quantita;
	private int soglia;
	private int quantitaRiordino;
	private Libreria libreria;
	
//	private List<Vendita> vendite = new LinkedList<>();
	private int[] venditeMesi = new int[12];
	private int[] venditeSettimane = new int[52];

    public Libro(String titolo, String autore, int anno, double prezzo, Editore editore, Libreria libreria) {
		this.titolo = titolo;
		this.autore = autore;
		this.anno = anno;
		this.prezzo = prezzo;
		this.editore = editore;
		this.libreria = libreria;
	}

	public String getTitolo(){
        return titolo;
    }
    
    public String getAutore(){
        return autore;
    }
    
    public int getAnno(){
        return anno;
    }

    public double getPrezzo(){
        return prezzo;
    }
    
    public Editore getEditore(){
        return editore;
    }

    public void setQuantita(int q){ 
    	this.quantita = q;
    }
    
    public int getQuantita(){
        return quantita;	
    }
    
    public void aggiornaQuantita(){ 
    	quantita += quantitaRiordino;
    }

    public void registraVendita(int settimana, int mese){
//    	List<Vendita> v = vendite.stream().filter(x -> x.getMese()==mese && x.getSettimana()==settimana).collect(Collectors.toList());
//    	if(v.get(0) != null)
//    		v.get(0).aggiornaCopieVendute();
//    	else vendite.add(new Vendita(settimana, mese));
    	//TODO non funziona
    	this.venditeSettimane[settimana-1]++;
    	this.venditeMesi[mese-1]++;
    	
    	quantita--;
    	
    	if(quantita==soglia) {
    		libreria.createNewOrdine(this, this.quantitaRiordino);
    	}
    }
    
    public int[] getVenditeSettimane() {
    	int[] res = venditeSettimane;
		return res;
	}
    
    public int[] getVenditeMesi() {
    	int[] res = venditeMesi;
		return res;
	}

	public void setParametri(int soglia, int quantitaRiordino){ 
    	this.soglia = soglia;
    	this.quantitaRiordino = quantitaRiordino;
    }
}
