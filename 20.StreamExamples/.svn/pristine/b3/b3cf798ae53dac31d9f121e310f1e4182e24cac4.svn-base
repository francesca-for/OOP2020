package it.polito.po.university.students.streamexamples;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
//import java.util.stream.Collectors;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.polito.po.university.students.Course;
import it.polito.po.university.students.Student;
import it.polito.po.university.students.Student.Gender;

public class StudentStreams {
	List<Student> students;

	public StudentStreams() {
		students = new LinkedList<>();
		
		// Setup a sample of data structures
		students.add(new Student(100,"John","Smith",Gender.M));
		students.add(new Student(101,"Mary","Johnson",Gender.F));
		students.add(new Student(201,"Andrea","Rossi",Gender.M));
		students.add(new Student(202,"Giulia","Rossi",Gender.F));
		students.add(new Student(301,"Wei","Wang",Gender.M));
		students.add(new Student(302,"Fang","Li",Gender.F));

		Course c1 = new Course("01ABC","Object-Oriented Programming");
		Course c2 = new Course("02DEF","Databases");
		Course c3 = new Course("03GHI","Computer Networks");
//		Course c4 = new Course("03GHA","Computer Networks 2");
		
		//prende ogni studente nello stream e lo iscrive a c1
		students.stream().forEach( s -> s.enroll(c1));
//		students.stream().forEach(students.set(0, null));
//		INVECE DI
//		for(Student s : students){
//			s.enroll(c1);
//		}
		
		//iscrive al corso c2 solo i primi 3 studenti dello stream
		// [s1,s2,s3,s4,s5] lista
		// s1<->s2<->s3 stream
		students.stream().limit(3)
			.forEach( s -> s.enroll(c2));
//		INVECE DI
//		for(int i = 0;i<3;i++) {
//			students.get(i).enroll(c2);
//		}
//		
		//prende i primi 3 studenti a partire dal 3° (salta i primi 2)
		//e li iscrive a c3
		// s1,s2,s3,s4,s5,s6 -> s3,s4,s5,s6 -> s3,s4,s5
		students.stream().skip(2).limit(3)//stream di studenti, gli ultimi 3
		 	.forEach( s -> s.enroll(c3));
	}
	
	public StudentStreams(List<Student> students) {
		this.students = students;
	}


	/*---------------- Esercizi -------------------*/
	/* Esempi di metodi che lavorano con gli stream*/
	
	
	// scrivere il metodo che ottiene la collezione delle studentesse
	public Collection<Student> femaleStudents(){
//		List<Student> ris = new LinkedList<>();
//		for(Student s : students)
//			if(s.isFemale())
//				ris.add(s);
//		return ris;
		return students.stream().filter(s->s.isFemale()).collect(toList());
//		return students.stream().filter(Student::isFemale).collect(Collectors.toList());
//		return students.stream()
//				.filter(s->{
//								System.out.println("Filtering student "+s);
//								return s.isFemale();
//							})
//				.collect(toList());
	}

	// ottiene la collezione dei cognomi delle studentesse
	public Collection<String> femaleStudentSurnames(){
		// s1,s2,s3,s4,s5 //filtro solo donne -->
		// --> s1,s3,s5 // mappo ogni elemento studente->cognome (s.getSurname())-->
		// --> c1,c3,c5 // colleziono in lista
		return students.stream().
				filter(Student::isFemale).
				map(Student::getLast).
				collect(toList());
//		return students.stream().
//				peek(s->System.out.println("original stream: "+s)).
//				filter(s->s.isFemale()).
//				peek(s->System.out.println("after filter: "+s)).
//				map(s->s.getLast()).
//				peek(s->System.out.println("after map: "+s)).
//				collect(toList());
	}	
	
	
	
	// ottiene gli studenti di nome "John"
	public Collection<Student> studentsNamedJohn(){
		return students.stream().
				filter(s->s.getFirst().equals("John")).collect(toList());
//		return students.stream().
//				filter(new Predicate<Student>() {
//					@Override
//					public boolean test(Student t) {
//						return t.getFirst().equals("John");
//					}
//				})
//				.collect(toList());		
	}
	
	// ottiene la collezione dei cognomi (distinti) degli studenti
	public Collection<String> lastNames(){
		// s1,s2,s3,s4,s5,s6 -map-> c1,c2,c3,c1,c4,c2 -distinct-> c1,c2,c3,c4 -> [c1,c2,c3,c4]
		return students.stream().map(Student::getLast).distinct().collect(toList());
//		return students.stream().map(Student::getLast).collect(toSet());
	}

	
	// ottiene le lunghezze dei nomi propri degli studenti
	public Collection<Integer> namesLenghts(){
		return students.stream().map(s->s.getFirst().length()).collect(toList());
//				collect(Collectors.toCollection(TreeSet::new));
	}

	// ottiene gli studenti iscritti a due o più corsi
	public Collection<Student> studentsWithTwoEnrollments(){
		return students.stream().filter(s->s.enrolledIn().size()>=2).collect(toList());
	}

	// trova il numero di studenti iscritti a 2 o più corsi
	public int numStudentWithTwoEnrollments(){
//		return (int) students.stream().filter(s -> s.enrolledIn().size()>=2).count();
//		return students.stream()
//				.filter(s->s.enrolledIn().size()>=2)
//				.collect(toList())
//				.size();
		return students.stream().filter(s->s.enrolledIn().size()>=2)
				.collect(Collectors.counting()).intValue();
	}

	// ottiene tutti i corsi a cui gli studenti sono iscritti
	// = almeno uno studente iscritto
	public Collection<Course> coursesWithStudents(){
		return students.stream().flatMap(s -> s.enrolledIn().stream())
				.distinct().collect(toList());
		// Stream<Course> -collect(toList)-> Collection<Course>
	}
	

	// ottiene tutti i titoli dei corsi a cui 
	// gli studenti sono iscritti (senza ripetizioni)
	public Collection<String> nameCoursesWithStudents(){
		return students.stream()
				//.filter(s->s.enrolledIn().size()>0) non serve, se flatmap trova stream vuoto lo salta
				.flatMap(s->s.enrolledIn().stream())
				.map(Course::getTitle)
				.collect(toSet()); // così elimino duplicati, in alternativa distinct->collect(toList)	
	}

	// ottiene la lunghezza del cognome più lungo (tra quelli degli studenti) 
	public int maxLastNameLength(){
		return students.stream().mapToInt(s -> s.getLast().length()).max().orElse(0) ;
//		return students.stream().map(s -> s.getLast().length()).
//				collect(Collectors.maxBy(new Comparator<Integer>() {
//
//					@Override
//					public int compare(Integer o1, Integer o2) {
//						return o1-o2;
//					}
//				})).orElse(0);
		//map -> Stream<Integer>
		//mapToInt -> IntStream
	}

	// ottiene lo studente con il nome più lungo
	public Optional<Student> studentWithLongestName(){
//		return students.stream().
//		collect(Collectors.maxBy(new Comparator<Student>() {
//
//			@Override
//			public int compare(Student s1, Student s2) {
//				return s1.getFirst().length()-s2.getFirst().length();
//			}
//		}));
		return students.stream().
				collect(Collectors.maxBy(
						Comparator.comparingInt(
								s->s.getFirst().length())));
//		return students.stream().
//				collect(Collectors.maxBy(
//						Comparator.comparing(
//								s->s.getFirst().length())));
	}
	
	// ottiene la lista ordinata alfabeticamente
	// dei nomi propri degli studenti maschi
	public Collection<String> maleNames(){
		return students.stream().
			filter(Student::isMale).
			map(Student::getFirst).
			sorted().collect(toList());
//			collect(Collectors.toCollection(TreeSet::new));
	}

	// ottiene una stringa con la lista ordinata alfabeticamente
	// dei nomi propri degli studenti maschi
	// String ret = "{Andrea,John,Wei}"
	public String maleNamesString(){
		return students.stream().
				filter(Student::isMale).
				map(Student::getFirst).
				sorted().collect(Collectors.joining(",","{","}"));
	}

	// raggruppa gli studenti per genere
	public Map<Student.Gender,List<Student>> studentsByGender(){
		// <Student.Male->[s1,s3,s5]> <chiave->valore>
		// <Student.Female->[s2,s4,s6]>
		// classifier : Student ----> Gender 
		// NO Map<Student.Gender,Stream<Student>>
		// downstream collector: per ogni gruppo Stream<Student> --> List<Student>
		return students.stream().collect(
											Collectors.groupingBy(
														Student::getGender //classifier
//														,HashMap::new // supplier a.k.a. mapFactory
//														,Collectors.toList() // downstream collector
													)
										);
	}

	// trova il numero di studenti per genere
	public Map<Student.Gender,Long> numStudentsByGender(){
		return students.stream().collect(
				Collectors.groupingBy(
							Student::getGender //classifier
//							,HashMap::new // supplier a.k.a. mapFactory
							,Collectors.counting() // downstream collector
						)
			);
	}

	// raggruppa gli studenti per numero di corsi frequentati
	public Map<Long,List<Student>> studentsByNumCourses(){
		return students.stream().collect(
				Collectors.groupingBy(
							 s -> (long) s.enrolledIn().size()//classifier
//							,Collectors.toList() // downstream collector
						)
			);
	}

	// un metodo che dice se esistono studenti
	// con il nome passato come parametro
	 public Boolean isNamePresent(String name){
		return students.stream()
//				.filter(s->s.getFirst().equals(name))
//				.count()>0;
				.anyMatch(s->s.getFirst().equals(name));
		
//      EQUIVALENTE A ANYMATCH
//		for(Student s : students)
//		{
//			if(s.getFirst().equals(name))
//				return true;
//		}
//		return false;
	 }
	 
	// un metodo che dice se tutti gli studenti sono di genere maschile
	public Boolean allMales(){
//		return !students.stream().anyMatch(s->s.getGender().equals(Gender.F));
		return students.stream()
				.allMatch(s->s.getGender().equals(Gender.M));
	}

	//un metodo che dice se nessuno studente è di genere maschile
	public Boolean noMales(){
		return students.stream()
				.noneMatch(s->s.getGender().equals(Gender.M));
//		return students.stream()
//				.allMatch(s->s.getGender().equals(Gender.F));
	}


	//un metodo che trova il primo studente con nome passato come parametro
	public Optional<Student> getFirstStudentWithName(String name){
		return students.stream()
//				.filter(s -> {
//					System.out.println(s);
//					return s.getFirst().equals(name);
//				})
				.filter(s -> s.getFirst().equals(name))
				.findFirst();
	}
	
	// un metodo che stampa il numero medio di corsi
	// a cui è iscritto ogni studente
	public double getAverageCourseNumber(){
//		return students.stream()
//				.mapToInt(s->s.enrolledIn().size())
//				.average().orElse(0.0);
		
		return students.stream()
				.collect(Collectors.averagingDouble(
								s -> s.enrolledIn().size()
							)
						);
	}

	//un metodo che stampa informazioni statistiche sul numero di corsi
	//a cui è iscritto ogni studente
	public IntSummaryStatistics getCourseNumberStat(){
		return students.stream()
				.collect(Collectors.summarizingInt(
								s -> s.enrolledIn().size()
							)
						);
	}

		

	
	public static void main(String[] args) {
		StudentStreams studStream = new StudentStreams();
		System.out.println(studStream.getCourseNumberStat());
	}
	
	
}

