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
	
	public void setOpen(boolean open){
		this.open = open;
	}
	
	@Override
	protected StringBuffer layout(String pad) {
		StringBuffer res = new StringBuffer();
		res.append("[").append(getName()).append("]Tap -> ");
		res.append( getOutput().layout( pad + blanks(res.length()) ) );
		return res;
	}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		double outFlow = (open?inFlow:0);
		observer.notifyFlow("Tap",getName(),inFlow, outFlow);
		getOutput().simulate(outFlow,observer);	
	}
}
