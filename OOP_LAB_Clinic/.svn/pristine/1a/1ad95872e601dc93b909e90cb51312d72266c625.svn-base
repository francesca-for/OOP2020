package clinic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Doctor extends Patient{
	private int docID;
	private String specialization;
	private int numPatients = 0;
	
	private Map<String, Patient> patients_x_doc = new HashMap<>(); 

	public Doctor(String first, String last, String ssn, int docID, String specialization) {
		super(first, last, ssn);
		 this.docID = docID;
		 this.specialization = specialization;
	}

	public void addNewPatient(Patient patient) {
		patients_x_doc.put(patient.getSsn(), patient);
		numPatients++;
	}

	public int getDocID() {
		return docID;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public Collection<Patient> getPatients() {
//	public Collection getPatients() {
		Collection<Patient> res =  patients_x_doc.values();
		return res;	
	}
	
	public int getNumPatients() {
		return numPatients;
	}

	@Override
	public String toString() {
		return super.toString() + " [" + docID + "]: " + specialization;
	}
	
	public String toStringPNumber() {
		return String.format("%3d", numPatients) + " : " + docID + " " + this.getLast() + " " 
									+ this.getFirst();
	}

	public void remove(Patient patient) {
		patients_x_doc.remove(patient);
	}
	
}
