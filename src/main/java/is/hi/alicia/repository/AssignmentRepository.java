package is.hi.alicia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import is.hi.alicia.model.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Long>{

	    
}
