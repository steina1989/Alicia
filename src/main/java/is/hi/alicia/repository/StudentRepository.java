package is.hi.alicia.repository;

import org.springframework.data.repository.CrudRepository;

import is.hi.alicia.model.Assignment;
import is.hi.alicia.model.Student;
import is.hi.alicia.model.Teacher;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
}
