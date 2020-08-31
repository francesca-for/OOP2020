package clinic;

public class Patient {
	private String first;
	private String last;
	private String ssn;
	
	private Doctor doctor;

	public Patient(String first, String last, String ssn) {
		this.first = first;
		this.last = last;
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return last + " " + first + " (" + ssn + ")";
	}
	
	public void setDoctor(Doctor doctor) {
		if(this.doctor!=null)
			doctor.remove(this);
		this.doctor = doctor;
		this.doctor=doctor;
		doctor.addNewPatient(this);
	}

	public String getSsn() {
		return ssn;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	
	public String getFirst() {
		return first;
	}
	
	public String getLast() {
		return last;
	}
	
}
