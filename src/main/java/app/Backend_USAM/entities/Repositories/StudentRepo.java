package app.Backend_USAM.entities.Repositories;

import org.springframework.data.repository.CrudRepository;

import app.Backend_USAM.entities.Student;

public interface StudentRepo  extends CrudRepository<Student, Integer>{

}
