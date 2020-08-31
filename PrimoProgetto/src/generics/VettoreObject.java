package generics;

import java.util.Arrays;

public class VettoreObject {
   private static final int DEFAULT_SIZE = 10;
   protected Object[] elementi;  // array di riferimenti a Object 
   protected int next;
   
   public VettoreObject() {
	   elementi = new Object[DEFAULT_SIZE];
   }

   public VettoreObject(int iniziale) {
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
   
   public void add(Object elemento) {
	   if(next==elementi.length) {
		   resize();
	   }
	   elementi[next++] = elemento;
   }
   
   public Object get(int indice) {
	   if(indice<0 || indice>=next) {
		   System.err.println("Accesso fuori dai limiti!");
		   return null;
	   }
	   return elementi[indice];
   }
   
   public void put(int indice, Object valore) {
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
