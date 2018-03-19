package is.hi.alicia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import is.hi.alicia.model.Answer;
import is.hi.alicia.model.Assignment;

public interface AnswerRepository extends CrudRepository<Answer, Long>{

}
