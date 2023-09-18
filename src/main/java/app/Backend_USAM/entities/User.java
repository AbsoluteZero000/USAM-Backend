package app.Backend_USAM.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import app.Backend_USAM.controllers.Request.SignUpRequest;
import app.Backend_USAM.controllers.Request.CreationRequest.UserCreationRequest;
import app.Backend_USAM.util.enums.Degree;
import app.Backend_USAM.util.enums.Gender;
import app.Backend_USAM.util.enums.Language;
import app.Backend_USAM.util.enums.Role;
import app.Backend_USAM.util.enums.Skill;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Setter
@Getter
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Column(unique=true)
    private String email;
    private String password;
    private int age;
    private Gender gender;
    private String location;
    private Degree degree;
    private ArrayList<Language> languages;
    private ArrayList<Skill> skills;
    private Date startDate;
    private String title;
    private Role role;
    private int departmentId;
    private ArrayList<Integer> postsIds;


    public User(UserCreationRequest req){
        edit(req);
    }
    public User(SignUpRequest req){
        this.name = req.name;
        this.email = req.email;
        this.password = req.password;
        this.age = req.age;
        this.title = req.title;
    }
    public User(String name, String email, int age, Gender gender, String location, Degree degree, ArrayList<Language> languages, ArrayList<Skill> skills, Date startDate, String title, Role role){
        this.name = name;
        this.age = age;
        this.email = email;
        this.location = location;
        this.degree = degree;
        this.languages = languages;
        this.skills = skills;
        this.gender = gender;
        this.title = title;
        this.startDate = startDate;
        this.role = role;
    }
    public void edit(UserCreationRequest req){
        this.name = req.getName();
        this.age = req.getAge();
        this.email = req.getEmail();
        this.location = req.getLocation();
        this.degree = req.getDegree();
        this.languages = req.getLanguages();
        this.skills = req.getSkills();
        this.gender = req.getGender();
        this.title = req.getTitle();
        this.startDate = req.getStartDate();
        this.role = req.getRole();
    }
    public void addToPosts(int id){
        if(postsIds == null)
            postsIds = new ArrayList<Integer>();
        postsIds.add(id);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
        }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

}
