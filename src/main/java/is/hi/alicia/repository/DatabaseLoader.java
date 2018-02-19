package is.hi.alicia.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import is.hi.alicia.model.Assignment;
import is.hi.alicia.model.Course;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final AssignmentRepository repository;

	@Autowired
	public DatabaseLoader(AssignmentRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Assignment("Verkefni 1"));
		this.repository.save(new Assignment("Verkefni 2"));
		this.repository.save(new Assignment("Verkefni 3"));

	}
}