package is.hi.alicia.repository;

import org.springframework.data.repository.CrudRepository;

import is.hi.alicia.model.Assignment;
import is.hi.alicia.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{

}
