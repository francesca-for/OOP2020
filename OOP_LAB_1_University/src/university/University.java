package university;

//import java.util.logging.Logger;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {
	
//	protected final static Logger logger = Logger.getLogger("University");
	protected static final int MAX_STUD = 1000;
	protected static final int FIRST_ID = 10000;
	protected static final int MAX_COURSES = 50;
	protected static final int FIRST_C_CODE = 10;
	private String name;
	private String rector;
	protected int numStud = 0;
	protected int numCourses = 0;
	protected Students[] students = new Students[MAX_STUD];
	protected Courses[] courses = new Courses[MAX_COURSES];
	
	/**
	 * Constructor
	 * @param name name of the university
	 */
	public University(String name){
		this.name=name;
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
	 * Retrieves the first ID number
	 * 
	 * @return
	 */
	public static int getFirstId() {
		return FIRST_ID;
	}

	/**
	 * Retrieves the first course code
	 * 
	 * @return
	 */
	public static int getFirstCCode() {
		return FIRST_C_CODE;
	}

	/**
	 * Enroll a student in the university
	 * 
	 * @param first first name of the student
	 * @param last last name of the student
	 * @return
	 */
	public int enroll(String first, String last){
		if(numStud>=MAX_STUD)
			return -1;
		students[numStud] = new Students(first, last, FIRST_ID + numStud);
		
	//	logger.info("New student enrolled: " + FIRST_ID+numStud + ", " + first + " " + last);
		
		return FIRST_ID+(numStud++);
	}

	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id the id of the student
	 * @return information about the student
	 */
	public String student(int studentID){
		if(studentID<FIRST_ID)
			return "Matricola non esistente\n";
		for(Students s : students) {
			if(s==null)
				break;
			if(s.getStudID() == studentID) {
				return s.toString();
			}
		}
		return "Matricola non esistente\n";
	}

	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param title = title of the course
	 * @param teacher = name of the teacher
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){
		if(numCourses>=MAX_COURSES)
			return -1;
		courses[numCourses] = new Courses(title, teacher, numCourses+FIRST_C_CODE);
		
//		logger.info("New course activated: " + numCourses+FIRST_C_CODE + ", " + title + " " + teacher);
		
		return FIRST_C_CODE+(numCourses++);
	}

	/**
	 * Retrieve the information for a given course
	 * 
	 * @param code unique code of the course
	 * @return information about the course
	 */
	public String course(int code){
		if(code<FIRST_C_CODE)
			return "Codice corso non esistente";
		for(Courses c : courses){
			if(c==null)
				break;
			if(c.getCode()==code){
				return c.toString();
			}
		}
		return "Codice corso non esistente";
	}

	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseID id of the course
	 */
	public void register(int studentID, int courseID){
		Students s = students[studentID-FIRST_ID];
		Courses c = courses[courseID-FIRST_C_CODE];
		s.add(c);
		c.add(s);
		
//		logger.info("Student " + studentID + " signed up for course " + courseID);
	}

	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		if(courseCode<FIRST_C_CODE || courseCode>numCourses+FIRST_C_CODE)
			return "Corso non esistente";
		return courses[courseCode-FIRST_C_CODE].studentsList();
	}

	/**
	 * Retrieves the study plan for a student
	 * 
	 * @param studentID id of the student
	 * @return list of courses the student is registered for
	 */
	public String studyPlan(int studentID){
		if(studentID<FIRST_ID || studentID>numStud+FIRST_ID)
			return "Matricola non esistente";
		return students[studentID-FIRST_ID].coursesList();
	}


}

