package app.Backend_USAM.entities.Repositories;

import app.Backend_USAM.entities.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import app.Backend_USAM.util.enums.Role;




@Service
@Transactional
public interface UserRepo extends CrudRepository<User, Integer>
{
    User findByName(String name);
    User findByEmail(String email);
    User findByRole(Role role);
    @Query("select u from User u  where lower(u.name) like lower(concat('%', :search, '%'))")
    User findStaffByName(@Param("search") String name);
}
