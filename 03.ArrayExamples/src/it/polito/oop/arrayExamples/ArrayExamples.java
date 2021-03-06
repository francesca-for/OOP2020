package it.polito.oop.arrayExamples;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExamples {

	public static void main(String[] args) {		
		{
			int[] array1 = {1,2};
			int[] array2 = {1,2};
			System.out.println(array1==array2);
			System.out.println("ciao"=="ciao");
			char[] arrayChar1 = {'c','i','a','o'};
			char[] arrayChar2 = {'c','i','a','o'};
			System.out.println(arrayChar1==arrayChar2);
			System.out.println(Arrays.equals(array1, array2));
			System.out.println(Arrays.equals(arrayChar1, arrayChar2));
			
			System.out.println("");
		}
		
		{
			int[] internalArray1 = {1,2};
			int[] internalArray2 = {1,2};
			int[][] array1 = {internalArray1, internalArray2};
			int[][] array2 = {internalArray2, internalArray1};
			System.out.println(array1==array2);
			System.out.println(Arrays.equals(array1, array2));
			
			System.out.println(Arrays.deepEquals(array1, array2));
			 // -> Arrays.deepEquals(array1[0], array2[0])
				// -> Arrays.equals(array1[0], array2[0]) -> TRUE
			 // -> Arrays.deepEquals(array1[1], array2[1])
				// -> Arrays.equals(array1[1], array2[1]) -> TRUE
			// TRUE && TRUE = TRUE
			
			System.out.println("");
		}
		
		{
			String[] array = {"quattro", "sei", "tre", "cinque", "dieci"};
			String[] a = Arrays.copyOf(array, array.length);
			String[] b = Arrays.copyOf(array, array.length+10);
			String[] c = Arrays.copyOf(array, array.length-2);
			
			String temp = ""; 
			for(String stringa : a)
				temp += stringa + ",";
			System.out.println(temp);
	
			temp = ""; 
			for(String stringa : b)
				temp += stringa + ",";
			System.out.println(temp);
	
			temp = ""; 
			for(String stringa : c)
				temp += stringa + ",";
			System.out.println(temp);
	
			System.out.println(Arrays.equals(array, a));
			
			System.out.println("");
		}
		
		{
			String[] a = {"quattro", "sei", "tre", "cinque", "dieci"};
			System.out.println("Array iniziale: "+Arrays.toString(a));
			Arrays.sort(a);
			System.out.println("Array ordinato: "+Arrays.toString(a));
			
			Arrays.sort(a, new Comparator<String>(){
				@Override
				public int compare(String o1, String o2) {
					// o1=="uno" o2=="cinque"
					// str_to_int(o1)==1 str_to_int(o2)==5
					// str_to_int(o1)-str_to_int(o2)==-4  —>  o1<o2
					return str_to_int(o1)-str_to_int(o2);
				}	
			});
			
			System.out.println("Array ordinato crescente come numeri: "+Arrays.toString(a));
			
			Arrays.sort(a, new Comparator<String>(){
				@Override
				public int compare(String o1, String o2) {
					return -str_to_int(o1)+str_to_int(o2);
				}	
			});
			System.out.println("Array ordinato decrescente come numeri: "+Arrays.toString(a));
			
			System.out.println("");
		}
		
		{
			String[] a = {"quattro", "sei", "tre", "cinque", "dieci"};
			
			StringNumberComparator comp = new StringNumberComparator();
			Arrays.sort(a,comp);
			// oppure Arrays.sort(a,new StringNumberComparator());
			System.out.println(Arrays.toString(a));
			
			System.out.println("");
		}
		
		{
			String[] a = {"quattro", "sei", "tre", "cinque", "dieci"};
			System.out.println(Arrays.toString(a));
			int index = Arrays.binarySearch(a, "undici", new StringNumberComparator());
			int index2 = Arrays.binarySearch(a, "tre", new StringNumberComparator());
			System.out.println("Ricerca uno:"+index);
			System.out.println("Ricerca tre:"+index2);
			System.out.println("a[index2]: "+a[index2]);
			
			System.out.println("");
		}
	}
	

	private static int str_to_int(String s1)
	{
		int output = -1;
		
		if(s1.equals("uno")) return 1;
		if(s1.equals("due")) return 2;
		if(s1.equals("tre")) return 3;
		if(s1.equals("quattro")) return 4;
		if(s1.equals("cinque")) return 5;
		if(s1.equals("sei")) return 6;
		if(s1.equals("sette")) return 7;
		if(s1.equals("otto")) return 8;
		if(s1.equals("nove")) return 9;
		if(s1.equals("dieci")) return 10;
		if(s1.equals("undici")) return 11;
		
		return output;
	}
	
}
