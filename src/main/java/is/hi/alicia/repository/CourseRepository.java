package is.hi.alicia.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import is.hi.alicia.model.Assignment;
import is.hi.alicia.model.Course;

//@PreAuthorize("hasRole('ROLE_USER')")
public interface CourseRepository extends CrudRepository<Course, Long>{
	
}
