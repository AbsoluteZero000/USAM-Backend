package app.Backend_USAM.entities;

import app.Backend_USAM.controllers.Request.CreationRequest.PostCreationRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String postTitle;
    private String postContent;
    private int ownerId;

    public Post(PostCreationRequest req){
        edit(req);
    }
    public void edit(PostCreationRequest req){
        this.postTitle = req.getPostTitle();
        this.postContent = req.getPostContent();
        this.ownerId = req.getOwnerId();
    }
}
