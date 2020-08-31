package diet;

class Time implements Comparable<Time>{
	private int h, m;
	
	Time(int h, int m){
		this.h = h;
		this.m = m;
	}

	@Override
	public int compareTo(Time o) {
		return (m + 60 * h) - (o.m + o.h * 60);
	}

	@Override
	public String toString() {
		return String.format("%02s:%02s", h, m);
	}
	
//	@Override 	// sbagliato, il formato deve essere hh:mm
//	public String toString() {
//		return h + ":" + m;
//	}
	
}
