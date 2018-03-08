package is.hi.alicia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import is.hi.alicia.model.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Long>{

	// Frekar fancy, Spring býr til search undirhlekk þegar
	// þetta er notað.
    Assignment findByName(@Param("name") String name);

}
