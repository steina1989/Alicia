package is.hi.alicia.repository;

import org.springframework.data.repository.CrudRepository;
import is.hi.alicia.model.User;

public interface UserRepository extends CrudRepository<User, Long>{


}
