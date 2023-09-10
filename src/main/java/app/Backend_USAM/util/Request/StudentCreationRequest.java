package app.Backend_USAM.util.Request;

import java.sql.Date;
import java.util.ArrayList;

import app.Backend_USAM.util.enums.Degree;
import app.Backend_USAM.util.enums.Gender;
import app.Backend_USAM.util.enums.Language;
import app.Backend_USAM.util.enums.Skill;

public class StudentCreationRequest {
    private String name;
    private String email;
    private int age;
    private Gender gender;
    private String location;
    private Degree degree;
    private ArrayList<Language> languages;
    private ArrayList<Skill> skills;
    private Date admissionDate;
    private int year;
    private float gpa;

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



        public Date getAdmissionDate() {
            return admissionDate;
        }
        public void setAdmissionDate(Date admissionDate) {
            this.admissionDate = admissionDate;
        }
        public int getYear() {
            return year;
        }
        public void setYear(int year) {
            this.year = year;
        }
        public float getGpa() {
            return gpa;
        }
        public void setGpa(float gpa) {
            this.gpa = gpa;
        }
}
