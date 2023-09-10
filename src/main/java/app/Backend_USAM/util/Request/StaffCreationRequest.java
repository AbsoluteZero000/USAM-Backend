package app.Backend_USAM.util.Request;
import java.sql.Date;
import java.util.ArrayList;

import app.Backend_USAM.util.enums.Degree;
import app.Backend_USAM.util.enums.Gender;
import app.Backend_USAM.util.enums.Language;
import app.Backend_USAM.util.enums.Skill;

public class StaffCreationRequest {



    private String name;
    private String email;
    private int age;
    private Gender gender;
    private String location;
    private Degree degree;
    private ArrayList<Language> languages;
    private ArrayList<Skill> skills;
    private Date joinDate;
    private String title;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getLocation() {
        return location;
    }
    public Degree getDegree() {
        return degree;
    }
    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    public ArrayList<Language> getLanguages() {
        return languages;
    }
    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }
    public ArrayList<Skill> getSkills() {
        return skills;
    }
    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
    public void setLocation(String location) {
        this.location = location;
    }



        public Date getJoinDate() {
            return joinDate;
        }
        public void setJoinDate(Date joinDate) {
            this.joinDate = joinDate;
        }

}


