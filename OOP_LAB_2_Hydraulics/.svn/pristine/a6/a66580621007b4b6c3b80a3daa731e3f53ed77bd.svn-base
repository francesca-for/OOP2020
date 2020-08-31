package hydraulic;

/**
 * Represents the sink, i.e. the terminal element of a system
 *
 */
public class Sink extends Element {

	/**
	 * Constructor
	 * @param name
	 */
	public Sink(String name) {
		super(name);
	}
	
	@Override
	public void connect(Element elem){
		// in caso cercassi di connetere qualcosa ad uno scarico non succede nulla
	}

	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		observer.notifyFlow("Sink", getName(), inFlow, SimulationObserver.NO_FLOW);
	}
	
	@Override
	void simulate(double inFlow, SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		observer.notifyFlow("Sink", getName(), inFlow, SimulationObserver.NO_FLOW);
		if(enableMaxFlowCheck && inFlow>maxFlow)
			observer.notifyFlowError(this.getClass().getName(), this.getName(), inFlow, maxFlow);
	}
	
	@Override
	public StringBuffer layout(String pad) {
		StringBuffer res = new StringBuffer();
		res.append("[").append(getName()).append("]Sink *");
		return res;
	}
	
}
