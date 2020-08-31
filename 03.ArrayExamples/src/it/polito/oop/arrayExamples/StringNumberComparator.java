package it.polito.oop.arrayExamples;

import java.util.Comparator;

public class StringNumberComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return str_to_int(o1)-str_to_int(o2);
	}

	private int str_to_int(String s1)
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
		
		
		return output;
	}
}
