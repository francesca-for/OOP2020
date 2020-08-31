package it.polito.oop.rubrica.classi;

public class Rubrica {
	String nome;
	
	private Voce[] voci;
	private int next;
	
	private final int MAX_VOCI = 100;
	
	public Rubrica(String nome)
	{
		this.nome = nome;
		this.voci = new Voce[MAX_VOCI];
		this.next = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String ricerca(String strDaCercare)
	{
		String output = "Voce non presente in elenco";
		
		for(Voce v : voci)
		{
			if(v==null)
				break;
			
			if(v.getNome().contains(strDaCercare) ||
					v.getCognome().contains(strDaCercare) ||	
					v.getNumTelefono().contains(strDaCercare)
					)
//			if(v.getNome() == strDaCercare)
			{
				output = "Trovato: " + v.toString();
				break;
			}
		}
		
		return output;
	}
	
	public String elenco()
	{
		String output = "(";

//		METODO 1		
//		for(int i=0; i<next; i++)
//		{
//			output += voci[i].toString();
//			if(i!=next-1)
//				output += " , ";
//		}
		
//		METODO 2		
		for(Voce v : voci)
			if(v!=null)
			{
				output += v.toString();
				output += " , ";
			}
		output = output.substring(0, output.length()-2);
		
		
		output += ")";
		return output;
	}
	
	public String voce(int indice)
	{
		String output = "";
		
		if(indice <= 0)
			output = "Indice deve essere > 0";
		else if(indice <= next)
			output = voci[indice-1].toString();
		else output = "Indice troppo grande";
		
		return output;
	}
	
	public void aggiungi(String nome, String cognome, String numTelefono)
	{
		Voce temp = new Voce(nome, cognome, numTelefono);
		
		if(next<MAX_VOCI)
		{
			voci[next] = temp;
			next++;
		}
		else
			System.out.println("Impossibile aggiungere voce: rubrica piena");
	}
	
	public String primo()
	{
//		String output = "";
//		if(next!=0)
//			output = voci[0].toString();
//		else
//			output = "Rubrica vuota";
//		return output;
		return voce(1);
	}
	
	
}
