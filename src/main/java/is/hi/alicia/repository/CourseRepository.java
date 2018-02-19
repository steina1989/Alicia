package is.hi.alicia.repository;

import org.springframework.data.repository.CrudRepository;

import is.hi.alicia.model.Assignment;
import is.hi.alicia.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{

}
