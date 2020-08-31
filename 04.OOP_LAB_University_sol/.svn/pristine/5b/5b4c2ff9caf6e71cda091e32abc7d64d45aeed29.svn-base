package university;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {

	// costanti
	public static final int MAX_STUDENTS = 1000;
	public static final int INITIAL_ID = 10000;
	public static final int MAX_COURSES = 50;
	public static final int INITIAL_CODE = 10;
	public static final int MAX_COURSES_PER_STUDENT = 25;
	public static final int MAX_STUDENTS_PER_COURSE = 100;
	
	// attributi
	private String name;
	private String rector;
	
	private Student[] studenti;
	private int nextId = INITIAL_ID;
	
	private Course[] corsi;
	private int nextCode = INITIAL_CODE;
	
	/**
	 * Constructor
	 * @param name name of the university
	 */
	public University(String name){
		this.name = name;
		
		this.studenti = new Student[MAX_STUDENTS];
		this.corsi = new Course[MAX_COURSES];
	}
	
	/**
	 * Getter for the name of the university
	 * @return name of university
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Defines the rector for the university
	 * 
	 * @param first
	 * @param last
	 */
	public void setRector(String first, String last){
		this.rector = first + " " + last; 
	}
	
	/**
	 * Retrieves the rector of the university
	 * 
	 * @return
	 */
	public String getRector(){
		return rector;
	}
	
	/**
	 * Enroll a student in the university
	 * 
	 * @param first first name of the student
	 * @param last last name of the student
	 * @return
	 */
	public int enroll(String first, String last){
		if(nextId >= INITIAL_ID + MAX_STUDENTS)
			return -1;
		Student s = new Student(nextId, first, last);
		studenti[nextId - INITIAL_ID] = s; 
		return nextId++;
	}
	
	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id the id of the student
	 * @return information about the student
	 */
	public String student(int id){
		Student s = studenti[id-INITIAL_ID];
		if(s == null) // if(id >= nextID) 
			return "Matricola non trovata";
		return s.toString();
	}
	
	/*
	 * public Student getStudent(int id)
	 * {
	 * 		return studenti[id-INITIAL_ID];
	 * }
	 */
	
	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param title title of the course
	 * @param teacher name of the teacher
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){
		Course c = new Course(nextCode, title, teacher);
		corsi[nextCode - INITIAL_CODE] = c;
		return nextCode++;
	}
	
	/**
	 * Retrieve the information for a given course
	 * 
	 * @param code unique code of the course
	 * @return information about the course
	 */
	public String course(int code){
		return corsi[code - INITIAL_CODE].toString();
	}
	
	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode){
		Student s = studenti[studentID-INITIAL_ID];
		// Student s = getStudent(studentID);
		
		Course c = corsi[courseCode-INITIAL_CODE];
		
		s.enroll(c);
		c.enroll(s);
	}
	
	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		Course c = corsi[courseCode-INITIAL_CODE];
		return c.attendees();
	}

	/**
	 * Retrieves the study plan for a student
	 * 
	 * @param studentID id of the student
	 * @return list of courses the student is registered for
	 */
	public String studyPlan(int studentID){
		Student s = studenti[studentID-INITIAL_ID];
		return s.courses();
	}
}
