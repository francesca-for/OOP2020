package generics;

public class EsempioVettore {

	public static void main(String[] args) {
		
		VettoreObject v = new VettoreObject();
		
		v.add("Primo elemento");
		
		String s = (String) v.get(0);
		//Integer i = (Integer) v.get(0);  // errore si verifica a run-time
		System.out.println(s);
		
		Vettore<String> vs = new Vettore<String>();
		
		v.add("Primo elemento");
		
		String s2 = vs.get(0); // scrittura + semplice
		//Integer i = (Integer) vs.get(0); // errore identificato dal compilatore

		System.out.println(s2);
	}

}
