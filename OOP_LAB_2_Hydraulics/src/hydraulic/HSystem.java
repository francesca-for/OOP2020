package hydraulic;

import java.util.Arrays;

/**
 * Main class that act as a container of the elements for
 * the simulation of an hydraulics system 
 * 
 */
public class HSystem {
	
	private static final int MAX_ELEM = 100;
	protected Element[] elements = new Element[MAX_ELEM];
	protected int numElements = 0;
	
	/**
	 * Adds a new element to the system
	 * @param elem
	 */
	public void addElement(Element elem){
		if(numElements>=MAX_ELEM) {
			System.out.println("Impossibile aggiungere nuovo elemento");
			return;
		}
		elements[numElements++] = elem;
	}
	
	/**
	 * returns the element added so far to the system.
	 * If no element is present in the system an empty array (length==0) is returned.
	 * 
	 * @return an array of the elements added to the hydraulic system
	 */
	public Element[] getElements(){
		return Arrays.copyOf(elements, numElements);
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
