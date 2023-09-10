package app.Backend_USAM.controllers;

import java.util.ArrayList;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.Backend_USAM.entities.Repositories.StudentRepo;
import app.Backend_USAM.Response.Response;
import app.Backend_USAM.entities.Student;
import app.Backend_USAM.entities.User;
import app.Backend_USAM.enums.Degree;
import app.Backend_USAM.enums.Gender;
import app.Backend_USAM.enums.Language;
import app.Backend_USAM.enums.Skill;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    public StudentController(){

    }

    @GetMapping("/test")
    public String test(){
        long now = System.currentTimeMillis();
        studentRepo.save(new Student("Ahmed Wael", "Example@Gmail.com", 0, Gender.Male, "Giza, Egypt", Degree.BCS, new ArrayList<Language>(){
            {
                add(Language.ARABIC);
                add(Language.ENGLISH);
            }
        }, new ArrayList<Skill>(){
            {
                add(Skill.Admin);
                add(Skill.Crypto);
            }
        }, new Date(now), (float) 3.45, 4));
        return "test";
    }

    @GetMapping("/students")
    public Iterable<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }

    @PutMapping("/edit")
    public Response editStudent(@RequestParam int id, @RequestBody User editedUser){
        return new Response("sorry not yet implemented lol");
    }




}
