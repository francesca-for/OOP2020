package university;

class Courses {
	private static final String SEPARATOR = ",";
	private static final int MAX_STUD_PER_C = 100;
	private static final int FIRST_ID = University.getFirstId();
	
	private String title;
	private String teacher;
	private int courseCode;
	
	private int numStud=0;
	private Students[] students = new Students[MAX_STUD_PER_C];
	
	private int cumulativeGrade = 0;
	private int numExams=0;
	private Integer[] grade = new Integer[MAX_STUD_PER_C];

	public Courses(String title, String teacher, int courseCode){
		this.title = title;
		this.teacher = teacher;
		this.courseCode=courseCode;
	}
	
	public int getCode() {
		return courseCode;
	}
	
	public String getTitle() {
		return title;
	}

	public Students[] getStudents(){
		return students;
	}
	
	public void add(Students student) {
		if(numStud>=MAX_STUD_PER_C)
			System.out.println("Impossibile aggiungere nuovo corso al carico didattico dello studente "+student.getStudID());
		students[numStud]=student;
		numStud++;
	}
	
	public String studentsList() {
		StringBuffer res = new StringBuffer();
		for(Students s : students) {
			if(s==null)
				break;
			res.append(s.toString()).append("\n"); 
		}
		return res.toString().substring(0, res.length()-1);
	}
	
	public void setGrade(int studentId, int grade) {
		if(this.grade[studentId-FIRST_ID]!=null) {
			System.out.println("E' già stato registrato un voto per lo studente specificato");
			return;
		}
		this.grade[studentId-FIRST_ID]=grade;
		cumulativeGrade += grade;
		numExams++;
	}

	public float avgGrade() {
		return (float)cumulativeGrade/numExams;
	}
	
	@Override
	public String toString() {
		return courseCode + SEPARATOR + title + SEPARATOR + teacher;
	}
	
}
