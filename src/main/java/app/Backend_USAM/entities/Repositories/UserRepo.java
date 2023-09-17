package app.Backend_USAM.entities.Repositories;

import app.Backend_USAM.entities.User;

import java.util.Optional;

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
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByRole(Role role);
    @Query("select u from User u  where lower(u.name) like lower(concat('%', :search, '%'))")
    Optional<User> findStaffByName(@Param("search") String name);
    Optional<User> findByPassword(String password);
    @Query("select u from User u where lower(u.email) like lower(?1) and u.password = ?2")
    Optional<User> findByEmailAndPassword(String email, String password);
}
