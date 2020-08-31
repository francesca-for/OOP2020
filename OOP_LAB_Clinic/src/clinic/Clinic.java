package clinic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a clinic with patients and doctors.
 * 
 */
public class Clinic {
	
	private Map<String, Patient> patients = new HashMap<>();
	private Map<Integer, Doctor> doctors = new HashMap<>();
	
	/**
	 * Add a new clinic patient.
	 * 
	 * @param first first name of the patient
	 * @param last last name of the patient
	 * @param ssn SSN number of the patient
	 */
	public void addPatient(String first, String last, String ssn) {
		Patient p = new Patient(first, last, ssn);
		patients.put(ssn, p);
	}


	/**
	 * Retrieves a patient information
	 * 
	 * @param ssn SSN of the patient
	 * @return the object representing the patient
	 * @throws NoSuchPatient in case of no patient with matching SSN
	 */
	public String getPatient(String ssn) throws NoSuchPatient {
		if(! patients.containsKey(ssn)) throw new NoSuchPatient();
		return patients.get(ssn).toString();
	}

	/**
	 * Add a new doctor working at the clinic
	 * 
	 * @param first first name of the doctor
	 * @param last last name of the doctor
	 * @param ssn SSN number of the doctor
	 * @param docID unique ID of the doctor
	 * @param specialization doctor's specialization
	 */
	public void addDoctor(String first, String last, String ssn, int docID, String specialization) {
		Doctor d = new Doctor(first, last, ssn, docID, specialization);
		patients.put(ssn, d);
		doctors.put(docID, d);
	}

	/**
	 * Retrieves information about a doctor
	 * 
	 * @param docID ID of the doctor
	 * @return object with information about the doctor
	 * @throws NoSuchDoctor in case no doctor exists with a matching ID
	 */
	public String getDoctor(int docID) throws NoSuchDoctor {
		if(! doctors.containsKey(docID)) throw new NoSuchDoctor();
		return doctors.get(docID).toString();
	}
	
	/**
	 * Assign a given doctor to a patient
	 * 
	 * @param ssn SSN of the patient
	 * @param docID ID of the doctor
	 * @throws NoSuchPatient in case of not patient with matching SSN
	 * @throws NoSuchDoctor in case no doctor exists with a matching ID
	 */
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
		if(!patients.containsKey(ssn))
			throw new NoSuchPatient();
		Patient p = patients.get(ssn);
		if(!doctors.containsKey(docID))
			throw new NoSuchDoctor();
		Doctor d = doctors.get(docID);
		p.setDoctor(d);
	}
	
	/**
	 * Retrieves the id of the doctor assigned to a given patient.
	 * 
	 * @param ssn SSN of the patient
	 * @return id of the doctor
	 * @throws NoSuchPatient in case of not patient with matching SSN
	 * @throws NoSuchDoctor in case no doctor has been assigned to the patient
	 */
	public int getAssignedDoctor(String ssn) throws NoSuchPatient, NoSuchDoctor {
//		Optional<Patient> p = patients.values().stream().filter(x -> x.getSsn().equals(ssn)).findFirst();
//		p.getDoctor().getDocID();    //non devo avere un Optional
//		return p;
		if(!patients.containsKey(ssn)) throw new NoSuchPatient();
		if(patients.get(ssn).getDoctor()==null) throw new NoSuchDoctor();
		return patients.get(ssn).getDoctor().getDocID();
	}
	
	/**
	 * Retrieves the patients assigned to a doctor
	 * 
	 * @param id ID of the doctor
	 * @return collection of patient SSNs
	 * @throws NoSuchDoctor in case the {@code id} does not match any doctor 
	 */
	public Collection<String> getAssignedPatients(int id) throws NoSuchDoctor {
		Doctor d = doctors.get(id);
		if(d==null) throw new NoSuchDoctor();
		return d.getPatients().stream().map(p -> p.getSsn()).collect(Collectors.toList());
//		return (Collection<String>) d.getPatients().stream().map(p -> ((Patient) p).getSsn()).collect(Collectors.toList());
	}


	/**
	 * Loads data about doctors and patients from the given stream.
	 * <p>
	 * The text file is organized by rows, each row contains info about
	 * either a patient or a doctor.</p>
	 * <p>
	 * Rows containing a patient's info begin with letter {@code "P"} followed by first name,
	 * last name, and SSN. Rows containing doctor's info start with letter {@code "M"},
	 * followed by badge ID, first name, last name, SSN, and specialization.<br>
	 * The elements on a line are separated by the {@code ';'} character possibly
	 * surrounded by spaces that should be ignored.</p>
	 * <p>
	 * In case of error in the data present on a given row, the method should be able
	 * to ignore the row and skip to the next one.<br>

	 * 
	 * @param readed linked to the file to be read
	 * @throws IOException in case of IO error
	 */
	public void loadData(Reader reader) throws IOException {
		try(BufferedReader r = new BufferedReader(reader)){
			r.lines().map(l -> l.split("\\s*;\\s*"))   // regExp 
			.forEach(items -> {
				try {
					if(items[0].trim().equalsIgnoreCase("P")) {
						addPatient(items[1], items[2], items[3].trim());
					}
					else
						if(items[0].trim().equalsIgnoreCase("M")) {
							addDoctor(items[2], items[3], items[4], Integer.parseInt(items[1]), items[5]);
						}
						else System.out.println("Unrecognized line type");
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.err.println("Missing elements on the line");
				}
				catch(NumberFormatException e) {
					System.err.println("Cannot parse integer value");
				}
			});
		}
	}
	
	/**
	 * Retrieves the collection of doctors that have no patient at all.
	 * The doctors are returned sorted in alphabetical order
	 * 
	 * @return the collection of doctors' ids
	 */
	public Collection<Integer> idleDoctors(){
		Comparator<Doctor> c = Comparator.comparing(Doctor::getLast).thenComparing(Doctor::getFirst);
		
		List<Doctor> sortedDoctors = doctors.values().stream().sorted(c).collect(Collectors.toList());
				
		List<Doctor> idleD = sortedDoctors.stream().filter(x -> x.getPatients().size()==0 ).collect(Collectors.toList());
		
		List<Integer> res = new LinkedList<>();
		idleD.forEach(x -> res.add(x.getDocID()));
		
		return res;
	}

	/**
	 * Retrieves the collection of doctors having a number of patients larger than the average.
	 * 
	 * @return  the collection of doctors' ids
	 */
	public Collection<Integer> busyDoctors(){
//		int totP = 0;
//		for(Doctor d : doctors.values()) {
//			totP += d.getPatients().size();
//		}
//		float patientsAvg = totP/doctors.size();
		double average = doctors.values().stream().mapToInt(d -> d.getNumPatients()).average().orElse(0.0);
		
	    // usando gli stream
		return doctors.keySet().stream().filter(x -> doctors.get(x).
				getNumPatients() > average).collect(Collectors.toList());
	}

	/**
	 * Retrieves the information about doctors and relative number of assigned patients.
	 * <p>
	 * The method returns list of strings formatted as "{@code ### : ID SURNAME NAME}" where {@code ###}
	 * represent the number of patients (printed on three characters).
	 * <p>
	 * The list is sorted by decreasing number of patients.
	 * 
	 * @return the collection of strings with information about doctors and patients count
	 */
	public Collection<String> doctorsByNumPatients(){
		Comparator<Doctor> c = Comparator.comparing(Doctor::getNumPatients).reversed();
		
//		List<Doctor> sortedByNum = doctors.values().stream().collect(Collectors.toList());
//		sortedByNum.sort(c);
//		
//		Collection<String> res = new LinkedList<>();
//		for(Doctor d : sortedByNum) {
//			res.add(d.toStringPNumber());
//		}
//		
//		return res;
//		
		return doctors.values().stream().sorted(c).
				map( d -> String.format("%3d", d.getNumPatients()) + " : " + d.getDocID() + " " + d.getLast() + " " + d.getFirst())
				.collect(Collectors.toList());
	}
	
	/**
	 * Retrieves the number of patients per (their doctor's)  speciality
	 * <p>
	 * The information is a collections of strings structured as {@code ### - SPECIALITY}
	 * where {@code SPECIALITY} is the name of the speciality and 
	 * {@code ###} is the number of patients cured by doctors with such speciality (printed on three characters).
	 * <p>
	 * The elements are sorted first by decreasing count and then by alphabetic speciality.
	 * 
	 * @return the collection of strings with speciality and patient count information.
	 */
	public Collection<String> countPatientsPerSpecialization(){
		// mappa con specializzazioni e num di pazienti
		Map<String, Integer> spec = doctors.values().stream()
                .collect(Collectors.groupingBy(Doctor::getSpecialization, Collectors.summingInt(x -> x.getNumPatients())));  // due modi per scriverlo  
		
		// creo lista con tutte le entrate della mappa
		List<Map.Entry<String, Integer>> entries = new LinkedList<>(spec.entrySet());
		
		Comparator<Map.Entry<String, Integer>> cmp = ( (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> {
//			int comparator = b.getValue()-a.getValue();
//			return comparator!=0 ? comparator : a.getKey().compareTo(b.getKey());
			int comparator = a.getValue()-b.getValue();
			return comparator!=0 ? comparator : b.getKey().compareTo(a.getKey());
			});
		
		entries.sort(cmp);
		
		Collection<String> res = new LinkedList<>();
		
		for(Map.Entry<String, Integer> e : entries) {
			res.add( String.format("%3d", e.getValue()) + " - " + e.getKey());
		}
		return res;
	}
	
}
