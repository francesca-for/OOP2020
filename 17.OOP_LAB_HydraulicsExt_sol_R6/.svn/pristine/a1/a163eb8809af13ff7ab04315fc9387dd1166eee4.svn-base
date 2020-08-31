package hydraulic;

import java.util.Arrays;

/**
 * Represents the generic abstract element of an hydraulics system.
 * It is the base class for all elements.
 *
 * Any element can be connect to a downstream element
 * using the method {@link #connect(Element) connect()}.
 */
public abstract class Element {
	
	private String name;
	private Element[] outputs;
	
	/**
	 * Constructor
	 * @param name the name of the element
	 */
	public Element(String name){
		this.name=name;
		outputs = new Element[1];
	}

	 Element(String name, int numOutputs){
		this.name=name;
		outputs = new Element[numOutputs];
	}

	/**
	 * getter method
	 * @return the name of the element
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Connects this element to a given element.
	 * The given element will be connected downstream of this element
	 * @param elem the element that will be placed downstream
	 */
	public void connect(Element elem){
		outputs[0] = elem;
	}
	
	public void connect(Element elem, int index){
		outputs[index] = elem;
	}
	
	/**
	 * Retrieves the element connected downstream of this
	 * @return downstream element
	 */
	public Element getOutput(){
		return outputs[0];
	}

	public Element[] getOutputs(){
		return outputs;
	}
	
	abstract void simulate(double inFlow, SimulationObserver observer);
	
	protected abstract StringBuffer layout(String padding);
	
	/**
	 * Returns a string consisting of 'n' blanks
	 * 
	 * @param n number of blanks to generate
	 * @return
	 */
	protected static String blanks(int n) {
		char[] res = new char[n];
		Arrays.fill(res, ' ');
		return new String(res);
	}
}
