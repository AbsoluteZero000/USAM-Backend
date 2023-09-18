package app.Backend_USAM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Backend_USAM.controllers.Request.CreationRequest.UserCreationRequest;
import app.Backend_USAM.entities.User;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserController userController;


    @GetMapping("/getprofile")
    public User getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userController.getUserByName(email);
        return user;
    }
    @PutMapping("/editprofile")
    public User editLoggedInUser(UserCreationRequest req){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userController.getUserByName(email);
        user.edit(req);
        return userController.editUser(user);
    }
}
