package app.Backend_USAM.entities.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import app.Backend_USAM.entities.Department;

public interface DepartmentRepo extends CrudRepository<Department, Integer> {
    Optional<Department> findByName(String name);

}
