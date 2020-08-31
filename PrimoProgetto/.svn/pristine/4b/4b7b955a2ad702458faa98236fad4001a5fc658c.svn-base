package ereditarieta;

import java.util.Arrays;

public class Vettore {
   private static final int DEFAULT_SIZE = 10;
   protected int[] elementi;
   protected int next;
   
   public Vettore() {
	   elementi = new int[DEFAULT_SIZE];
   }

   public Vettore(int iniziale) {
	   elementi = new int[iniziale];
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
   
   public void add(int elemento) {
	   if(next==elementi.length) {
		   resize();
	   }
	   elementi[next++] = elemento;
   }
   
   public int get(int indice) {
	   if(indice<0 || indice>=next) {
		   System.err.println("Accesso fuori dai limiti!");
		   return Integer.MIN_VALUE;
	   }
	   return elementi[indice];
   }
   
   public void put(int indice, int valore) {
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
