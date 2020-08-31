package hydraulic;

import java.util.Arrays;

/**
 * Main class that act as a container of the elements for
 * the simulation of an hydraulics system 
 * 
 */
public class HSystem {
	
	private static final int MAX_SIZE = 100;
	private Element[] elements = new Element[MAX_SIZE];
	private int next = 0;
	
	/**
	 * Adds a new element to the system
	 * @param elem
	 */
	public void addElement(Element elem){
		elements[next++] = elem;
	}
	
	/**
	 * returns the element added so far to the system.
	 * If no element is present in the system an empty array (length==0) is returned.
	 * 
	 * @return an array of the elements added to the hydraulic system
	 */
	public Element[] getElements(){
//		Element result[] = new Element[next];
//		
//		for(int i=0; i<result.length; ++i) {
//			result[i] = elements[i];
//		}
		
		Element result[] = Arrays.copyOf(elements,next);
		
		return result;
	}
	
	/**
	 * Prints the layout of the system starting at each Source
	 */
	public String layout(){
		// TODO: to be implemented
		return null;
	}
	
	/**
	 * starts the simulation of the system
	 */
	public void simulate(SimulationObserver observer){
		for(Element e : elements)
			if(e!=null && e instanceof Source)
				e.simulate(-1, observer);
	}

}
