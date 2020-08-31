package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * The status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends Element {

	private double flow;
	
	public Source(String name) {
		super(name);
	}
	
	@Override
	public void setMaxFlow(double maxFlow) {
	}


	/**
	 * defines the flow produced by the source
	 * 
	 * @param flow
	 */
	public void setFlow(double flow){
		this.flow = flow;  
	}

	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		observer.notifyFlow("Source", getName(), SimulationObserver.NO_FLOW, flow);
		getOutput().simulate(flow, observer);
	}
	
	@Override
	void simulate(double inFlow, SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		observer.notifyFlow("Source", getName(), SimulationObserver.NO_FLOW, flow);
		if(enableMaxFlowCheck && inFlow>maxFlow)
			observer.notifyFlowError(this.getClass().getName(), this.getName(), inFlow, maxFlow);
		getOutput().simulate(flow, observer, enableMaxFlowCheck);
	}
	
	@Override
	public StringBuffer layout(String pad) {
		StringBuffer res = new StringBuffer();
		res.append("[").append(getName()).append("]Source –> ");
		return res.append(getOutput().layout(blanks(res.length())));
	}
	
}
