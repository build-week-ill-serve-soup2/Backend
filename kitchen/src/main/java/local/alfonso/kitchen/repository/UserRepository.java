package local.alfonso.kitchen.repository;

import local.alfonso.kitchen.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
