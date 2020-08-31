package university;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;
public class UniversityExt extends University {
	
	private static final String SEPARATOR = " ";
	private final static Logger logger = Logger.getLogger("University");

	public UniversityExt(String name) {
		super(name);
		// Example of logging
		logger.info("Creating extended university object");
	}
	
	public void exam(int studentId, int courseID, int grade) {
		if(grade<0 || grade>30) {
			System.out.println("Errore: il voto deve essere compreso tra 0-100");
			return;
		}
		students[studentId-FIRST_ID].setGrade(courseID, grade);
		courses[courseID-FIRST_C_CODE].setGrade(studentId, grade);
		
		logger.info("Student " + studentId + " took an exam in course " + courseID + " with grade " + grade);
	}

	public String studentAvg(int studentId) {
		float avg = students[studentId-FIRST_ID].avgGrade();
		if(Float.isNaN(avg)) //avg==-1)
			return "Student " + studentId + " hasn't taken any exams";
		return "Student " + studentId + ": " + avg;
	}
	
	public String courseAvg(int courseId) {
		float avg = courses[courseId-FIRST_C_CODE].avgGrade();
		if(Float.isNaN(avg))
			return "No student has taken the exam in " + courses[courseId-FIRST_C_CODE].getTitle();
		return "The average for the course " + courses[courseId-FIRST_C_CODE].getTitle() + " is: " + avg;
	}
	
	public String topThreeStudents() {
		StringBuffer res = new StringBuffer();
		Students[] topStudents = Arrays.copyOf(students, numStud);
//		Students temp;
		
//		for(int i=0; i<3; i++) {
//			for(int j=i; j<numStud; j++) {
//				if(topStudents[j].getScore() > topStudents[i].getScore()) {
//					temp = topStudents[i];
//					topStudents[i] = topStudents[j];
//					topStudents[j] = temp;
//				}
//			}
//		}
		
		Arrays.sort(topStudents, new Comparator<Students>(){
			@Override
			public int compare(Students s1, Students s2) {
				return (int)Math.signum(s2.getScore()-s1.getScore());
			}
		});
		
		for(int i=0; i<3 && i<numStud; i++)
			res.append(topStudents[i].getFirst()).append(SEPARATOR).append(topStudents[i].getLast()).append(SEPARATOR).append(topStudents[i].getScore()).append("\n");
		return res.toString().substring(0, res.length()-1);
	}
	
	@Override
	public int enroll(String first, String last) {
		int studentId = super.enroll(first, last);
		logger.info("New student enrolled: " + FIRST_ID+numStud + ", " + first + " " + last);
		return studentId;
	}
	
	@Override
	public int activate(String title, String teacher) {
		int courseCode = super.activate(title, teacher);
		logger.info("New course activated: " + numCourses+FIRST_C_CODE + ", " + title + " " + teacher);
		return courseCode;
	}
	
	@Override
	public void register(int studentID, int courseID) {
		super.register(studentID, courseID);
		logger.info("Student " + studentID + " signed up for course " + courseID);
	}
}
