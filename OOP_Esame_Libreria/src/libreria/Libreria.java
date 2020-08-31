package libreria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Libreria {
	private int idOrdine = 1;
	
	private Map<String, Editore> editori = new TreeMap<>( (String e1, String e2) -> {return e1.compareTo(e2);} );
	private List<Libro> libri = new LinkedList<>();
	private Map<Integer, Ordine> ordini = new HashMap<>();

    public Editore creaEditore(String nome, int tempoConsegna, String email) {
        Editore e = new Editore(nome, tempoConsegna, email);
        editori.put(nome, e);
        return e;
    }

    public Editore getEditore(String nome) {
        return editori.get(nome);
    }

    public Collection getEditori() {
        Collection<Editore> res = editori.values();
        return res;
    }

    public Libro creaLibro(String titolo, String autore, int anno, double prezzo, String nomeEditore)
    			throws EditoreInesistente {
        if(!editori.containsKey(nomeEditore)) throw new EditoreInesistente();
        Libro l = new Libro(titolo, autore, anno, prezzo, editori.get(nomeEditore), this);
        libri.add(l);
        return l;
    }
    
    public Libro getLibro(String autore, String titolo) {
    	List<Libro> res;
    	if(autore==null) {
//    		res = libri.stream().filter(x -> x.getTitolo().equals(titolo)).collect(Collectors.toList());
//    		return res.get(0);
    		return libri.stream().filter(x -> x.getTitolo().equals(titolo)).findAny().orElse(null);
    	}
    	else if(titolo==null) {
    		res = libri.stream().filter(x -> x.getAutore().equals(autore)).collect(Collectors.toList());
    		return res.get(0);
    	}
    	else {
    		res = libri.stream().filter(x -> x.getAutore().equals(autore) && x.getTitolo().equals(titolo)).collect(Collectors.toList());
    		return res.get(0);
    	}    
    }
    
    public Collection getClassificaSettimana(final int settimana) {
//    	Comparator<Libro> cmp = ( (Libro a, Libro b) -> {
//    				int res = ( b.getVendite().stream().filter(y -> y.getSettimana()==settimana).collect(Collectors.toList()).get(0).getCopieVendute() -
//    							a.getVendite().stream().filter(y -> y.getSettimana()==settimana).collect(Collectors.toList()).get(0).getCopieVendute() );
//    				return res; });
//    	
//    	return libri.stream().filter(
//    			x -> (x.getVendite().stream().filter(y -> y.getSettimana()==settimana).collect(Collectors.toList())!=null))
//    			.sorted(cmp).collect(Collectors.toList());
    	
    	Comparator<Libro> cmp = ( (Libro a, Libro b) -> {
				return b.getVenditeSettimane()[settimana-1] - a.getVenditeSettimane()[settimana-1];  });
    		
    	return libri.stream().sorted(cmp).collect(Collectors.toList());
    }
    
    public Collection getClassificaMese(final int mese) {
//    	Comparator<Libro> cmp = ( (Libro a, Libro b) -> {
//			int res = ( b.getVendite().stream().filter(y -> y.getMese()==mese).collect(Collectors.toList()).get(0).getCopieVendute() -
//						a.getVendite().stream().filter(y -> y.getMese()==mese).collect(Collectors.toList()).get(0).getCopieVendute() );
//			return res; });
//
//    	return libri.stream().filter(
//    			x -> (x.getVendite().stream().filter(y -> y.getMese()==mese).collect(Collectors.toList())!=null))
//    			.sorted(cmp).collect(Collectors.toList());
    	
    	Comparator<Libro> cmp = ( (Libro a, Libro b) -> {
				return b.getVenditeMesi()[mese-1] - a.getVenditeMesi()[mese-1];  });
		
    	return libri.stream().sorted(cmp).collect(Collectors.toList());
    }
    
    public void addOrdini(Ordine o) {
    	this.ordini.put(o.getNumero(), o);
    }
    
    public Collection getOrdini() {
        Collection<Ordine> res = ordini.values();
        return res;
    }
    
    public void ordineRicevuto(int numOrdine) {
    	Ordine o = ordini.get(numOrdine);
    	o.setIsConsegnato(true);
    	o.getLibro().aggiornaQuantita();
    }
    
    public void leggi(String file) {
    	try(BufferedReader r = new BufferedReader(new FileReader("file"))){
    		 r.lines().map(l -> l.split(";")).forEach(ln -> {
    			 try {
    				 if(ln[0].trim().equals("E")) {
    					 creaEditore(ln[1].trim(), Integer.parseInt(ln[2].trim()), ln[3].trim());
    				 }
    				 else if(ln[0].trim().equals("L")) {
    					creaLibro(ln[1].trim(), ln[2].trim(), Integer.parseInt(ln[3].trim()), Double.parseDouble(ln[4].trim()), ln[5].trim());
    				 }
    				 else System.out.println("Unrecognized line type");
    			 }
    			 catch(ArrayIndexOutOfBoundsException e) {
    					System.err.println("Missing elements on the line");
    			 }
    			 catch (NumberFormatException e) {
    				 System.err.println("Cannot parse integer value");
				}
    			catch (EditoreInesistente e) {
    				System.err.println("Editore inesistente");
				}
    		 });
    	}
    	catch(IOException exc) {
    		System.err.println("Errore file");
    	}
    }

	public void createNewOrdine(Libro libro, int quantitaRiordino) {
		Ordine o = new Ordine(libro, quantitaRiordino, idOrdine);
		ordini.put(o.getNumero(), o);	
		idOrdine++;
	}
}
