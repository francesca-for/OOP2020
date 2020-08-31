package it.polito.oop.futsal;

public class Associate {
	private int associateId;
	private String first;
	private String last;
	private String mobile;

	public Associate(int id, String first, String last, String mobile) {
		this.associateId = id;
		this.first = first;
		this.last = last;
		this.mobile = mobile;
	}

	public int getAssociateId() {
		return associateId;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getMobile() {
		return mobile;
	}
	

}
