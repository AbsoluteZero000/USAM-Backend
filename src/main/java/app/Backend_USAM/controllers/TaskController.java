package app.Backend_USAM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Backend_USAM.controllers.Request.CreationRequest.TaskCreationRequest;
import app.Backend_USAM.entities.Task;
import app.Backend_USAM.entities.User;
import app.Backend_USAM.entities.Repositories.TaskRepo;
import app.Backend_USAM.entities.Repositories.UserRepo;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/create")
    public Task createTask(@RequestBody TaskCreationRequest req){
        Task task = new Task(req);
        User user = userRepo.findById(req.getProfessorId()).get();
        user.addToTasksId(task.getId());
        task.setProfessorId(req.getProfessorId());
        userRepo.save(user);
        return taskRepo.save(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAllTasks()
    {
        return taskRepo.findAll();
    }
    @GetMapping("/task")
    public Task getTask(@RequestParam int id){
        return taskRepo.findById(id).get();
    }

    @GetMapping("/taskbyname")
    public Task getTaskByName(@RequestParam String name){
        return taskRepo.findByName(name);
    }

    @PutMapping("/edit")
    public Task editTask(@RequestParam int id, @RequestBody TaskCreationRequest req){


        Task Task = taskRepo.findById(id).get();
        Task.edit(req);
        return taskRepo.save(Task);
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam int id){
        Task Task = taskRepo.findById(id).get();
        taskRepo.delete(Task);
    }

}
