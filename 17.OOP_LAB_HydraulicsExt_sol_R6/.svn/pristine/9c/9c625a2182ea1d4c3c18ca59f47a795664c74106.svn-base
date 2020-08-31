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
		// Funziona se:
				// 1. il primo elemento aggiunto è la sorgente
				// 2. c'è una sola sorgente
//				return getElements()[0].layout("").toString();
					
				StringBuffer res = new StringBuffer();
				for(Element e : elements){
					if( e != null && e instanceof Source){
						res.append(e.layout(""));
					}
				}
				return res.toString();
	}
	
	/**
	 * Deletes a previously added element with the given name from the system
	 */
	public void deleteElement(String name) {
		// TODO: to be implemented
	}

	/**
	 * starts the simulation of the system; if enableMaxFlowCheck is true,
	 * checks also the elements maximum flows against the input flow
	 */
	public void simulate(SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		// TODO: to be implemented
	}
	
}
