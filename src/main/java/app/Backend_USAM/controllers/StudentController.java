package app.Backend_USAM.controllers;

import java.util.ArrayList;
import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import app.Backend_USAM.entities.Repositories.StudentRepo;
import app.Backend_USAM.util.Request.StudentCreationRequest;
import app.Backend_USAM.util.enums.Degree;
import app.Backend_USAM.util.enums.Gender;
import app.Backend_USAM.util.enums.Language;
import app.Backend_USAM.util.enums.Skill;
import app.Backend_USAM.entities.Student;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    public StudentController(){

    }

    @PostMapping("/create")
    public Student test(@RequestBody StudentCreationRequest req){

        return studentRepo.save(new Student(req));
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

    @GetMapping("/sample")
    public Student getSample(){
        ArrayList<Language> languages = new ArrayList<Language>(){{
            add(Language.ARABIC);
            add(Language.ENGLISH);
        }};
        ArrayList<Skill> skills = new ArrayList<Skill>(){{
        add(Skill.Admin);
        add(Skill.Bootstrap);
        }};
        return new Student("example", "A@gmail.com", 34, Gender.Male, "Giza, Egypt", Degree.BCS, languages ,skills, new Date(System.currentTimeMillis()), (float) 3.45, 4);
    }




}
