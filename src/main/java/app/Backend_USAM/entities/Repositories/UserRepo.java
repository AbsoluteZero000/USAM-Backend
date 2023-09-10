package app.Backend_USAM.entities.Repositories;

import app.Backend_USAM.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public interface UserRepo extends CrudRepository<User, Integer>
{

}
