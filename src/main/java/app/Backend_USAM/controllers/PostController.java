package app.Backend_USAM.controllers;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Backend_USAM.controllers.Request.CreationRequest.PostCreationRequest;
import app.Backend_USAM.entities.Post;
import app.Backend_USAM.entities.User;
import app.Backend_USAM.entities.Repositories.PostRepo;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostRepo repo;

    private final UserController userController;

    @PostMapping("/create")
    public Post createpost(@RequestBody PostCreationRequest req){
        Post post = new Post(req);
        User user = userController.getUser(req.getOwnerId());
        user.addToPosts(post.getId());
        post.setOwnerId(req.getOwnerId());
        userController.editUser(user);
        return repo.save(post);
    }

    @GetMapping("/posts")
    public Iterable<Post> getAllposts()
    {
        return repo.findAll();
    }
    @GetMapping("/post")
    public Post getpost(@RequestParam int id){
        return repo.findById(id).get();
    }


    @PutMapping("/edit")
    public Post editpost(@RequestParam int id, @RequestBody PostCreationRequest req){


        Post post = repo.findById(id).get();
        post.edit(req);
        return repo.save(post);
    }

    @DeleteMapping("/delete")
    public void deletepost(@RequestParam int id){
        Post post = repo.findById(id).get();
        repo.delete(post);
    }
}
