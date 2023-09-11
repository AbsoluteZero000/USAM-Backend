package app.Backend_USAM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Backend_USAM.entities.Task;
import app.Backend_USAM.entities.Staff;
import app.Backend_USAM.entities.Repositories.TaskRepo;
import app.Backend_USAM.entities.Repositories.StaffRepo;
import app.Backend_USAM.util.Request.TaskCreationRequestion;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepo taskRepo;
    private StaffRepo staffRepo;

    public TaskController(){}

    @GetMapping("/deps")
    public Iterable<Task> getAllTasks(){
        return taskRepo.findAll();
    }

    @GetMapping("/dep")
    public Task getTask(@RequestParam int id){
        return taskRepo.findById(id).get();
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody TaskCreationRequestion req){
        Task task = new Task(req);
        Staff head = staffRepo.findById(req.getProfid()).get();
        //task.setProffessor(head);
        //head.setTask(proffessor);
        staffRepo.save(head);
        return taskRepo.save(task);

    }

    @PutMapping("/edit")
    public Task editTask(@RequestParam int id, @RequestBody TaskCreationRequestion req){
        Task task = taskRepo.findById(id).get();
        task.edit(req);
        return taskRepo.save(task);
    }
}
