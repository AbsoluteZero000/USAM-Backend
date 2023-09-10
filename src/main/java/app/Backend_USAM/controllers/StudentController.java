package app.Backend_USAM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.Backend_USAM.entities.Repositories.StudentRepo;
import app.Backend_USAM.controllers.Request.StudentCreationRequest;
import app.Backend_USAM.entities.Student;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    public StudentController(){

    }

    @PostMapping("/create")
    public String test(@RequestBody StudentCreationRequest req){

        studentRepo.save(new Student(req));
        return "test";
    }

    @GetMapping("/students")
    public Iterable<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }
    @GetMapping("student")
    public Student getStudent(@RequestParam int id){
        return studentRepo.findById(id).get();
    }

    @PutMapping("/edit")
    public Student editStudent(@RequestParam int id, @RequestBody StudentCreationRequest req){
        Student student = studentRepo.findById(id).get();
        student.edit(req);
        return studentRepo.save(student);
    }




}
