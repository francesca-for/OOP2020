package clinic;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 * Represents a clinic with patients and doctors.
 * 
 */
public class Clinic {
	private Map<String,Person> patients = new HashMap<>();
	private Map<Integer,Doctor> doctors = new HashMap<>();

	/**
	 * Add a new clinic patient.
	 * 
	 * @param first first name of the patient
	 * @param last last name of the patient
	 * @param ssn SSN number of the patient
	 */
	public void addPatient(String first, String last, String ssn) {
		//ssn = ssn.replaceAll("\\s+", "");
		Person p = new Person(first,last,ssn);
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
		if(!patients.containsKey(ssn)) throw new NoSuchPatient();
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
		//ssn = ssn.replaceAll("\\s+", "");
		Doctor d = new Doctor(first,last,ssn,docID,specialization);
		doctors.put(docID, d);
		patients.put(ssn, d);
	}

	/**
	 * Retrieves information about a doctor
	 * 
	 * @param docID ID of the doctor
	 * @return object with information about the doctor
	 * @throws NoSuchDoctor in case no doctor exists with a matching ID
	 */
	public String getDoctor(int docID) throws NoSuchDoctor {
		if(!doctors.containsKey(docID)) throw new NoSuchDoctor();
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
		Person p = patients.get(ssn);
		Doctor d = doctors.get(docID);
		
		if(p==null) throw new NoSuchPatient();
		if(d==null) throw new NoSuchDoctor();
		
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
		Person p = patients.get(ssn);
		if(p == null) throw new NoSuchPatient();
		if(p.getDoctor() == null) throw new NoSuchDoctor();
		return p.getDoctor().getId();
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
		if(d==null) throw new NoSuchDoctor(id);
		return d.getPatients().stream().map(Person::getSSN).collect(Collectors.toList());
	}
	
	/**
	 * Loads data about doctors and patients from the given stream.
	 * <p>
	 * The text file is organized by rows, each row contains info about
	 * either a patient or a doctor.</p>
	 * <p>
	 * Rows containing a patient's info begin with letter {@code "P"} followed by first name,
	 * last name, and SSN. Rows containing doctor's info start with letter {@code "M"},
	 * followed by badge ID, first name, last name, SSN, and speciality.<br>
	 * The elements on a line are separated by the {@code ';'} character possibly
	 * surrounded by spaces that should be ignored.</p>
	 * <p>
	 * In case of error in the data present on a given row, the method should be able
	 * to ignore the row and skip to the next one.<br>

	 * 
	 * @param reader reader linked to the file to be read
	 * @throws IOException in case of IO error
	 */
	public void loadData(Reader reader) throws IOException {
		try(BufferedReader r = new BufferedReader(reader)){
			r.lines()
//			.peek(System.out::println)
			// "  P   ;    Cognome;   Nome ;    CGNNMM       "
			// "  P   ;    ;   Nome ;    CGNNMM       "
			.map( l -> l.split("\\s*;\\s*"))
//			.peek(l -> System.out.println(Arrays.toString(l)))
			// items : ["  P","Cognome";"Nome";"CGNNMM       "]
			.forEach( items -> {
				try{
					if(items[0].trim().equalsIgnoreCase("P")){
						addPatient(items[1],items[2],items[3].trim());
					}else
					if(items[0].trim().equalsIgnoreCase("M")){
						addDoctor(items[2],items[3],items[4],Integer.parseInt(items[1]),items[5].trim());
					}else{
						System.err.println("Unrecognized line type");
					}
				}catch(ArrayIndexOutOfBoundsException e){
					// "  M  ; 123 ; Cognome ; Nome ; ABCDEFG " <- manca specializzazione
					// quando accedo items[5] lancia ArrayIndexOutOfBoundsException
					System.err.println("Missing elements on the line");
				}catch(NumberFormatException e){
					// "  M  ; 123A ; Cognome ; Nome ; ABCDEFG ; cardiologo" <- id non numero, Integer.parseInt lancia eccezione
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
		return doctors.values().stream()
				.filter( d -> d.getPatients().isEmpty() )
		//		.sorted()  // Doctor must be Comparable	or
				.sorted(comparing(Doctor::getLast).thenComparing(Doctor::getFirst))
//				.map(d->d.getId())
				.map(Doctor::getId)
				.collect(toList())
				;
	}

	/**
	 * Retrieves the collection of doctors having a number of patients larger than the average.
	 * 
	 * @return  the collection of doctors' ids
	 */
	public Collection<Integer> busyDoctors(){
		double average = doctors.values().stream()
				.mapToInt( d -> d.getPatients().size())
				.average().orElse(0.0);
		return doctors.values().stream()
				.filter( d -> d.getPatients().size() > average )
				.map(d->d.getId())
				.collect(toList())
				;
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
//		return 
//		doctors.values().stream()
//				.sorted(
//						comparing(
//									(Doctor d)->d.getPatients().size()//,reverseOrder() in alternativa a reversed
//								)
////						.reversed()
//						)
//				.map( d -> String.format("%3d", d.getPatients().size()) + " : "
//							+ d.getId() +  " " + d.getLast() + " " + d.getFirst()
//					)
//				.collect(toList())
//				;
//		// OR
//		return doctors.values().stream()
//				.collect(groupingBy(d -> d.getPatients().size(),
//						()->new TreeMap<Integer,List<Doctor>>(reverseOrder()), // type pars required to guide compiler
//						toList()
//						))
//				// TreeMap<numero di pazienti assegnati,lista dottori con corrispondente numero pazienti assegnati>
//				// TreeMap con chiavi ordinati in modo decrescente
//		.entrySet().stream()
//		.flatMap(e->e.getValue().stream())
//		// con flatMap otteniamo stream dei dottori ordinati per numero di pazienti assegnati in modo decrescente
//		.map( d -> String.format("%3d", d.getPatients().size()) + " : "
//					+ d.getId() +  " " + d.getLast() + " " + d.getFirst()
//			)
//		.collect(toList())
//		;
//// OR
		return 
		patients.values().stream()
				.filter(p->p.getDoctor()!=null)
				.collect(groupingBy(Person::getDoctor,counting()))
				// dopo classifier : Map<Doctor,Stream<Person>>
				// dopo downstream collector (counting): Map<Doctor,numero di pazienti assegnati al dottore> 
				.entrySet().stream()
//				.sorted(comparing(Map.Entry::getValue).reversed()) // the compiler cannot infer the type
				.sorted(comparing(Map.Entry<Doctor,Long>::getValue).reversed()) // we can tell him the type
//				.sorted(comparing(Map.Entry::getValue,reverseOrder())) // or use reverseOrder()
				.map( e -> String.format("%3d", e.getValue()) + " : "
						+ e.getKey().getId() +  " " + e.getKey().getLast() + " " + e.getKey().getFirst()
				)
				.collect(toList())
				;
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
		return patients.values().stream()
				.filter(p->p.getDoctor()!=null)
				.collect(groupingBy( (Person p) -> p.getDoctor().getSpecialization(),
									 ()->new TreeMap<String,Long>(),
									 counting()
						))
				// Map<specializzazione, numero di pazienti assegnati a dottori con quella specializzazione>
				.entrySet().stream()
				.sorted(comparing(Map.Entry::getValue,reverseOrder()))
				.map( e -> String.format("%3d", e.getValue()) + " - " + e.getKey() ) 
				.collect(toList())
				;
	}

}
