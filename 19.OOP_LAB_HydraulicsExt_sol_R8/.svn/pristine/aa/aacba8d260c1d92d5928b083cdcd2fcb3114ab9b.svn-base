package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * The status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends ElementExt {

	private double flow;
	
	public Source(String name) {
		super(name);
	}

	public void setFlow(double flow){
		this.flow = flow;
	}

//	@Override
//	void simulate(double inFlow, SimulationObserver observer) {
//		observer.notifyFlow("Source",getName(),SimulationObserver.NO_FLOW, flow);
//		getOutput().simulate(flow,observer);	
//	}
	
	@Override
	protected void simulate(double inFlow, SimulationObserverExt observer, boolean enableMaxFlowChecks) {
		observer.notifyFlow("Source",getName(),SimulationObserver.NO_FLOW, flow);
		if(enableMaxFlowChecks && inFlow>maxFlow)
			observer.notifyFlowError(this.getClass().getName(), getName(), inFlow, maxFlow);
		getOutput().simulate(flow,observer,enableMaxFlowChecks);
	}
	
	@Override
	protected StringBuffer layout(String pad) {
		StringBuffer res = new StringBuffer();
		res.append("[").append(getName()).append("]Source -> ");
		res.append( getOutput().layout(blanks(res.length())) );
		return res;
	}
}
