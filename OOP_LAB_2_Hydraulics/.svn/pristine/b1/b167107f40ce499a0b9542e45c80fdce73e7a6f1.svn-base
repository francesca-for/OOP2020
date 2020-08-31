package hydraulic;

/**
 * Main class that act as a container of the elements for
 * the simulation of an hydraulics system 
 * 
 */
public class HSystemExt extends HSystem{
	
	/**
	 * Prints the layout of the system starting at each Source
	 */
	public String layout(){
		StringBuffer layout = new StringBuffer();
		for(Element e : elements) {
			if(e!=null && e instanceof Source) {
				layout.append(e.layout(""));
			}
		}
		return layout.toString();
	}
	
	/**
	 * Deletes a previously added element with the given name from the system
	 */
	public void deleteElement(String name) {
		boolean found = false;
		for(int i=0; i<numElements; i++) {
			if(!found && elements[i].getName().equals(name)) {
				if(elements[i] instanceof Split )
					return;
				found = true;
				Element input = elements[i].getInput();
				Element output = elements[i].getOutput();
				
				if(input!=null) {
					input.connect(output);
				}
				else if(output!=null)
					output.setInput(null);
			}
			if(found)
				elements[i]=elements[i+1];
		}
		numElements--;
	}

	/**
	 * starts the simulation of the system; if enableMaxFlowCheck is true,
	 * checks also the elements maximum flows against the input flow
	 */
	public void simulate(SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		for(Element e : elements)
	    	if(e!=null && e instanceof Source)
	    		e.simulate(-1, observer, enableMaxFlowCheck);
	}
	
}
