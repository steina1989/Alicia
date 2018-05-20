package is.hi.alicia.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import is.hi.alicia.model.Answer;


public interface AnswerRepository extends CrudRepository<Answer, Long>{
	@RestResource(rel="nextUnmarkedByAssignmentId",path="nextUnmarkedByAssignmentId")
    List<Answer> findFirstByAssignmentIdAndMarkedFalseOrderByDistanceAsc(@Param(value = "id") long id);
	
	@RestResource(rel="nextByAssignmentId",path="nextByAssignmentId")
    List<Answer> findFirstByAssignmentIdOrderByDistanceAsc(@Param(value = "id") long id);		
}
