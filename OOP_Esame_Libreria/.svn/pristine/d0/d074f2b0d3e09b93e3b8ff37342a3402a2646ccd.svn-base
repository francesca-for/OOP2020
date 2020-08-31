package libreria;

public class Ordine {
	private Libro libro;
	private int quantitaRiordino;
	boolean consegnato = false;
	private int numeroOrdine;
	private Libreria libreria;

    public Ordine(Libro libro, int quantitaRiordino, int idOrdine) {
    	this.libreria = libreria;
		this.libro = libro;
		this.quantitaRiordino = quantitaRiordino;
		this.numeroOrdine = idOrdine;
	}

	public Editore getEditore(){
        return libro.getEditore();
    }
    
    public Libro getLibro(){
        return libro;
    }
    
    public int getQuantita(){
        return quantitaRiordino;
    }

    public boolean isConsegnato(){
        return consegnato;
    }
    
    public void setIsConsegnato(boolean consegnato){
        if(this.consegnato==true)
        	System.out.println("L'ordine è già stato consegnato");
        else this.consegnato = consegnato;
    }

    public int getNumero(){
        return numeroOrdine;
    }
}
