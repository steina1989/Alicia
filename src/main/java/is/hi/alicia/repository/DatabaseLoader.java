package is.hi.alicia.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import is.hi.alicia.model.Assignment;
import is.hi.alicia.model.Course;
import is.hi.alicia.model.User;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final AssignmentRepository assignmentRepository;
	private final CourseRepository courseRep;
	private final UserRepository userRep;

	@Autowired
	public DatabaseLoader(AssignmentRepository repository, CourseRepository courseRep, UserRepository userRep) {
		this.assignmentRepository = repository;
		this.courseRep = courseRep;
		this.userRep = userRep;
	}

	@Override
	public void run(String... strings) throws Exception {

		User user = new User();
		user.setName("Hallgrímur Davíð");
		userRep.save(user);
		
		User user2 = new User();
		user2.setName("Steina Dögg");
		userRep.save(user2);
		
		Course course = new Course();
		course.setName("Tölvunarfræði 1 (hefur eitt verkefni)");
		
		Course course2 = new Course();
		course2.setName("Tölvunarfræði 2 (engin verkefni)");
		courseRep.save(course2);
		
		Assignment assignment = new Assignment();
		assignment.setName("Verkefni 1");
		assignment.setReturnDate(new Date());
		assignment.setQuestionDescription(
				"Inngangur að java forritun\n" + 
				"============\n" + 
				"\n" + 
				"Paragraphs are separated by a blank line.\n" + 
				"\n" + 
				"2nd paragraph. *Italic*, **bold**, and `monospace`. Itemized lists\n" + 
				"look like:\n" + 
				"\n" + 
				"  * this one\n" + 
				"  * that one\n" + 
				"  * the other one\n" + 
				"\n" + 
				"Note that --- not considering the asterisk --- the actual text\n" + 
				"content starts at 4-columns in.\n" + 
				"\n" + 
				"> Block quotes are\n" + 
				"> written like so.\n" + 
				">\n" + 
				"> They can span multiple paragraphs,\n" + 
				"> if you like.");
		
		
		
		assignmentRepository.save(assignment);
		course.addAssignment(assignment);
		
		courseRep.save(course);

	}
}