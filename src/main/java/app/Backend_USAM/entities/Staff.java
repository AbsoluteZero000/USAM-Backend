package app.Backend_USAM.entities;

import java.sql.Date;
import java.util.ArrayList;

import app.Backend_USAM.util.Request.StaffCreationRequest;
import app.Backend_USAM.util.enums.Degree;
import app.Backend_USAM.util.enums.Gender;
import app.Backend_USAM.util.enums.Language;
import app.Backend_USAM.util.enums.Skill;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Staff extends User{

    private Date joinDate;

    private String title;

    @OneToOne(mappedBy = "head", cascade = CascadeType.ALL)
    private Department department;


    public Staff(String name, String email, int age, Gender gender, String location, Degree degree, ArrayList<Language> languages, ArrayList<Skill> skills, Date joinDate, String title){
        super(name, email,  age, gender, location, degree, languages, skills);
        this.joinDate = joinDate;
        this.title = title;

    }
    public Staff(StaffCreationRequest req){
        super(req.getName(), req.getEmail(),  req.getAge(), req.getGender(), req.getLocation(), req.getDegree(), req.getLanguages(), req.getSkills());
        this.joinDate = req.getJoinDate();

    }

    public void edit(StaffCreationRequest req){
        setName(req.getName());
        setEmail(req.getEmail());
        setAge(req.getAge());
        setGender(req.getGender());
        setLocation(req.getLocation());
        setDegree(req.getDegree());
        setLanguages(req.getLanguages());
        setSkills(req.getSkills());
        this.joinDate = req.getJoinDate();

    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }


}


