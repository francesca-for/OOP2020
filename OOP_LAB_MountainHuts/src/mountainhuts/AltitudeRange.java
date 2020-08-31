package mountainhuts;

public class AltitudeRange {
	private String minAltitude;
	private String maxAltitude;
	
//	private int minAltitude;
//	private int maxAltitude;
	
	public AltitudeRange(String range) {
		String[] altitudes = range.split("-");
		this.minAltitude = altitudes[0];
		this.maxAltitude = altitudes[1];
	}
//	public AltitudeRange(String range) {
//		String[] altitudes = range.split("-");
//		this.minAltitude = Integer.parseInt(altitudes[0]);
//		this.maxAltitude = Integer.parseInt(altitudes[1]);
//	}
	
	@Override
	public String toString() {
		return minAltitude + "-" + maxAltitude;
	}

//	@Override
//	public String toString() {
//		return String.valueOf(minAltitude) + "-" + maxAltitude;
//	}

	public boolean includes(String altitude) {
		return altitude.compareTo(minAltitude)>=0 && altitude.compareTo(maxAltitude)<=0;
	}

	public String getMinAltitude() {
		return minAltitude;
	}

	public String getMaxAltitude() {
		return maxAltitude;
	}

}
