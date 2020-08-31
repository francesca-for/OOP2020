package generics;

import java.util.Arrays;

public class Vettore<T> {
   private static final int DEFAULT_SIZE = 10;
   protected Object[] elementi;
   protected int next;
   
   public Vettore() {
	   elementi = new Object[DEFAULT_SIZE];
   }

   public Vettore(int iniziale) {
	   elementi = new Object[iniziale];
   }

   protected void resize() {
//	   int[] nuovo = new int[elementi.length*2];
//	   for(int i=0; i<elementi.length; ++i) {
//		   nuovo[i] = elementi[i];
//	   }
//	   elementi = nuovo;
	   
	   // OPPURE
	   
	   elementi = Arrays.copyOf(elementi, elementi.length*2);
   }
   
   public void add(T elemento) {
	   if(next==elementi.length) {
		   resize();
	   }
	   elementi[next++] = elemento;
   }
   
   
   @SuppressWarnings("unchecked")
   public T get(int indice) {
	   if(indice<0 || indice>=next) {
		   System.err.println("Accesso fuori dai limiti!");
		   return null;
	   }
	   return (T)(elementi[indice]);  // io che ho scritto il codice so che è un cast corretto
   }
   
   public void put(int indice, T valore) {
	   if(indice<0 || indice>=next) {
		   System.err.println("Accesso fuori dai limiti!");
		   return;
	   }
	   elementi[indice] = valore;
   }
   
   public int size() {
	   return next;
   }
   
   public String toString() {
	   StringBuffer res = new StringBuffer("[");
	   for(int i=0; i<next; ++i) {
		   if(i>0) res.append(", ");
		   res.append(elementi[i]);
	   }
	   res.append("]");
	   return res.toString();
   }
   
}
