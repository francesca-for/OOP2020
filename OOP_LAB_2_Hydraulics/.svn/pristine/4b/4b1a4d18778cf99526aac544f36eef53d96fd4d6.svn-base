package hydraulic;

/**
 * Represents a multisplit element, an extension of the Split that allows many outputs
 * 
 * During the simulation each downstream element will
 * receive a stream that is determined by the proportions.
 */

public class Multisplit extends Split {
	
	private double[] proportions;
	private int numOutput;

	/**
	 * Constructor
	 * @param name
	 * @param numOutput
	 */
	public Multisplit(String name, int numOutput) {
		super(name, numOutput);
		this.numOutput= numOutput;
//		this.proportions = new double[numOutput];
	}
    
//	/**
//	 * returns the downstream elements
//	 * @return array containing the two downstream element
//	 */
//    public Element[] getOutputs(){
//    	return super.getOutputs();
//    }

//    /**
//     * connect one of the outputs of this split to a
//     * downstream component.
//     * 
//     * @param elem  the element to be connected downstream
//     * @param noutput the output number to be used to connect the element
//     */
//	@Override
//	public void connect(Element elem, int noutput){
//		super.connect(elem, noutput);
//	}
	
	/**
	 * Define the proportion of the output flows w.r.t. the input flow.
	 * 
	 * The sum of the proportions should be 1.0 and 
	 * the number of proportions should be equals to the number of outputs.
	 * Otherwise a check would detect an error.
	 * 
	 * @param proportions the proportions of flow for each output
	 */
	public void setProportions(double... proportions) {
		this.proportions = proportions;
	}
	
	@Override
	protected void simulate(double inFlow, SimulationObserver observer){
		double[] outFlow = new double[numOutput];
		for(int i=0; i<outFlow.length; i++) {
			outFlow[i] = inFlow * proportions[i];
		}
		observer.notifyFlow("Multisplit", getName(), inFlow, outFlow);
		Element[] e = getOutputs();
		for(int i=0; i<numOutput; i++) {
			e[i].simulate(outFlow[i], observer);
		}
	}
	
	@Override
	void simulate(double inFlow, SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		double []outFlow = new double[numOutput];
		for(int i=0; i<outFlow.length; i++)
			outFlow[i] = inFlow * proportions[i];
		
		observer.notifyFlow("Multisplit", getName(), inFlow, outFlow);
		if(enableMaxFlowCheck && inFlow>maxFlow)
			observer.notifyFlowError(this.getClass().getName(), this.getName(), inFlow, maxFlow);;
		
		for(int i=0; i<outFlow.length; i++) {
			getOutputs()[i].simulate(outFlow[i], observer, enableMaxFlowCheck);
		}
		
	}
	
	@Override
	public StringBuffer layout(String pad) {
		StringBuffer res = new StringBuffer();
		
		res.append("[").append(getName()).append("]Multisplit ");
		
		String subPad = pad + blanks(res.length());
		
		for(int i=0; i<this.numOutput; i++) {
			if(i>0)
				res.append("\n").append(subPad).append("|\n").append(subPad);
		
			if(i<this.numOutput-1)
				res.append("+-> ").append(getOutputs()[i].layout(subPad + "|   "));
			else
				res.append("+-> ").append(getOutputs()[i].layout(subPad +"    "));
		}
		return res;
	}
	
}
