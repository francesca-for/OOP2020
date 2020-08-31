package diet;

public class WorkingHours implements Comparable<WorkingHours>{
	private Time open;
	private Time close;
	
	public WorkingHours(String open, String close) {
		String []open_h_m = open.split(":");
		String []close_h_m = close.split(":");
		this.open = new Time(Integer.parseInt(open_h_m[0]), Integer.parseInt(open_h_m[1]));
		this.close = new Time(Integer.parseInt(close_h_m[0]), Integer.parseInt(close_h_m[1]));
	}

	public Time getOpen() {
		return open;
	}
	
	public Time getClose() {
		return close;
	}

	@Override
	public int compareTo(WorkingHours h) {
		return open.compareTo(h.open);
	}

	public boolean includes(Time time) {
		if(time.compareTo(open)>0 && time.compareTo(close)<0)
			return true;
		return false;
	}
	
}
