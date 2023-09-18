package app.Backend_USAM.entities.Repositories;

import org.springframework.data.repository.CrudRepository;

import app.Backend_USAM.entities.Task;


public interface TaskRepo extends CrudRepository<Task, Integer> {
    Task findByName(String name);
}
