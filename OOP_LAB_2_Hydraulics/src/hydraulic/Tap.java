package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method
 * {@link #setOpen(boolean) setOpen()}.
 */

public class Tap extends Element {

	private boolean open;

	public Tap(String name) {
		super(name);
	}
	
	/**
	 * Defines whether the tap is open or closed.
	 * 
	 * @param open  opening level
	 */
	public void setOpen(boolean open){
		this.open = open;
	}

	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlow = open? inFlow : 0;
		observer.notifyFlow("Tap", getName(), inFlow, outFlow);
		getOutput().simulate(outFlow, observer);
	}
	
	@Override
	void simulate(double inFlow, SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		double outFlow = open? inFlow : 0;
		observer.notifyFlow("Tap", getName(), inFlow, outFlow);
		if(enableMaxFlowCheck && inFlow>maxFlow)
			observer.notifyFlowError(this.getClass().getName(), this.getName(), inFlow, maxFlow);
		getOutput().simulate(outFlow, observer, enableMaxFlowCheck);
	}

	@Override
	public StringBuffer layout(String pad) {
		StringBuffer res = new StringBuffer();
		res.append("[").append(getName()).append("]Tap –> ");
		return res.append( getOutput().layout(pad + blanks(res.length())) );
	}
}
