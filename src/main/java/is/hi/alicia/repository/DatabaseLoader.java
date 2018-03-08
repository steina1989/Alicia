package is.hi.alicia.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import is.hi.alicia.model.Assignment;
import is.hi.alicia.model.Course;
import is.hi.alicia.model.Student;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final AssignmentRepository assignmentRepository;
	private final CourseRepository courseRep;
	private final StudentRepository studentRep;

	@Autowired
	public DatabaseLoader(AssignmentRepository repository, CourseRepository courseRep, StudentRepository studentRep) {
		this.assignmentRepository = repository;
		this.courseRep = courseRep;
		this.studentRep = studentRep;
	}

	@Override
	public void run(String... strings) throws Exception {
		Course course = new Course();
		course.setName("Tölvunarfræði 1");
		this.courseRep.save(course);

		Assignment as = new Assignment();
		as.setName("Verkefni 1");
		as.setCourse(course);
		// Course fær ekki verkefni 1 inn..
		//course.addAssignment(as);

		Student student = new Student();
		student.setName("Hallgrímur Davíð");
		
		course.addStudent(student);
		
		
		this.assignmentRepository.save(as);
		this.studentRep.save(student);
		this.courseRep.save(course);


	}
}