package it.polito.oop.futsal;

import it.polito.oop.futsal.Fields.Features;

public class Field implements FieldOption{
	private int FieldID;
	private Features features;
	private int numBooking = 0;
	
	public Field(int numField, Features f) {
		this.FieldID = numField;
		this.features = f;
	}
	
	public Features getFeatures() {
		return features;
	}

	public int getNumBooking() {
		return numBooking;
	}

	@Override
	public int getField() {
		return FieldID;
	}

	@Override
	public int getOccupation() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addNewBooking() {
		this.numBooking++;
		
	}

}
