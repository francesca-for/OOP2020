package university;

public class Students {
	private static final String SEPARATOR = " ";
	private static final int MAX_C_PER_STUD = 25;
	private static final int FIRST_C_CODE = University.getFirstCCode();
	
	private String first;
	private String last;
	private int studID;
	private float score;
	
	private int numCourses=0;
	private Courses[] courses = new Courses[MAX_C_PER_STUD];
	
	private int cumulativeGrade=0;
	private int numExams=0;
	private Integer[] grades = new Integer[MAX_C_PER_STUD]; // non vettore di int perchè se no avrei vettore inizializzato a 0. Voglio avere null per gli esami non ancora sostenuti
	
	public Students(String first, String last, int studID){
		this.first=first;
		this.last=last;
		this.studID=studID;
	}
	
	public int getStudID() {
		return studID;
	}
	
	public Courses[] getCourses() {
		return courses;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public float getScore() {
		return score;
	}
	
	public void add(Courses course) {
		if(numCourses>=MAX_C_PER_STUD)
			System.out.println("Impossibile iscrivere nuovo studente al corso "+course.getCode());
		courses[numCourses]=course;
		numCourses++;
	}

	public String coursesList(){
		StringBuffer res = new StringBuffer();
		for(Courses c : courses) {
			if(c==null)
				break;
			res.append(c.toString()).append("\n");
		}
		return res.toString().substring(0, res.length()-1);
	}
	
	public void setGrade(int courseID, int grade) {
		if(this.grades[courseID-FIRST_C_CODE]!=null) {
			System.out.println("E' già stato registrato un voto per il corso specificato");
			return;
		}
		this.grades[courseID-FIRST_C_CODE]=grade;
		cumulativeGrade += grade;
		numExams++;
		calculateScore();
	}

	public float avgGrade() {
		return (float)cumulativeGrade/numExams;
	}

	public void calculateScore() {
		this.score = avgGrade() + ((float)numExams/numCourses)*10;
	}
	
	@Override
	public String toString() {
		return studID + SEPARATOR + first + SEPARATOR + last;
	}
	
}
