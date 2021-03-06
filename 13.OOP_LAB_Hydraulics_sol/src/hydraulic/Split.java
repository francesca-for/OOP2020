package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will
 * receive a stream that is half the input stream of the split.
 */

public class Split extends Element {

//	private Element secondOutput;
	
	/**
	 * Constructor
	 * @param name
	 */
	public Split(String name) {
		super(name,2);
	}

	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlow = inFlow/2;
		observer.notifyFlow("Split", getName(), inFlow, outFlow, outFlow);
		for(Element e : getOutputs()) {
			e.simulate(outFlow, observer);
		}
	}
    
//	/**
//	 * returns the downstream elements
//	 * @return array containing the two downstream element
//	 */
//    public Element[] getOutputs(){
////    	Element[] res = { super.getOutput() , secondOutput} ;
////    	return res;
//    	return null;
//    }
//
//    /**
//     * connect one of the outputs of this split to a
//     * downstream component.
//     * 
//     * @param elem  the element to be connected downstream
//     * @param noutput the output number to be used to connect the element
//     */
//	public void connect(Element elem, int noutput){
//		if(noutput==0)
//			super.connect(elem);
//		else
//			secondOutput = elem;
//	}
}

