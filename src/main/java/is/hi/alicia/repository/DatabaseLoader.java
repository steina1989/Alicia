package is.hi.alicia.repository;

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
		course.setName("Tölvunarfræði 1");
		courseRep.save(course);
		
		

	}
}