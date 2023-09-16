package app.Backend_USAM.controllers;

import java.util.ArrayList;
import java.sql.Date;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import app.Backend_USAM.entities.Repositories.UserRepo;
import app.Backend_USAM.util.enums.Degree;
import app.Backend_USAM.util.enums.Gender;
import app.Backend_USAM.util.enums.Language;
import app.Backend_USAM.util.enums.Role;
import app.Backend_USAM.util.enums.Skill;
import app.Backend_USAM.controllers.Request.UserCreationRequest;
import app.Backend_USAM.entities.User;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    public UserController(){

    }

    @PostMapping("/create")
    public User test(@RequestBody UserCreationRequest req){

        return userRepo.save(new User(req));
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers()
    {
        return userRepo.findAll();
    }
    @GetMapping("user")
    public User getUser(@RequestParam int id){
        return userRepo.findById(id).get();
    }

    @GetMapping("/userbyname")
    public User getUserByName(@RequestParam String name){
        return userRepo.findByName(name);
    }

    @PutMapping("/edit")
    public User editUser(@RequestParam int id, @RequestBody UserCreationRequest req){


        User User = userRepo.findById(id).get();
        User.edit(req);
        return userRepo.save(User);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam int id){
        User User = userRepo.findById(id).get();
        userRepo.delete(User);
    }

    @GetMapping("/staff")
    public User getStaffByName(@RequestParam("name") String name){
        return userRepo.findStaffByName(name);
    }

    @GetMapping("/sample")
    public User getSample(){
        ArrayList<Language> languages = new ArrayList<Language>(){{
            add(Language.ARABIC);
            add(Language.ENGLISH);
        }};
        ArrayList<Skill> skills = new ArrayList<Skill>(){{
        add(Skill.Admin);
        add(Skill.Bootstrap);
        }};
        return new User("example", "A@gmail.com", 34, Gender.Male, "Giza, Egypt", Degree.BCS, languages ,skills, new Date(System.currentTimeMillis()), "Software Engineering Student", Role.STUDENT);
    }




}
