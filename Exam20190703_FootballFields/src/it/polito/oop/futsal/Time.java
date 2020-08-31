package it.polito.oop.futsal;

public class Time {
	private int hour;
	private int minutes;
	
	public Time(String time) {
		String[] t = time.trim().split(":");
		this.hour = Integer.parseInt(t[0]);
		this.minutes = Integer.parseInt(t[1]);
	}

	public int getHour() {
		return hour;
	}

	public int getMinutes() {
		return minutes;
	}
	 
}
