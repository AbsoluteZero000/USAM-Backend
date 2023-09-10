package app.Backend_USAM.entities;

import java.sql.Date;
import java.util.ArrayList;

import app.Backend_USAM.util.Request.StudentCreationRequest;
import app.Backend_USAM.util.enums.Degree;
import app.Backend_USAM.util.enums.Gender;
import app.Backend_USAM.util.enums.Language;
import app.Backend_USAM.util.enums.Skill;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends User{
    private Date admissionDate;
    private int year;
    private float gpa;

    private Student(){}
    public Student(String name, String email, int age, Gender gender, String location, Degree degree, ArrayList<Language> languages, ArrayList<Skill> skills, Date admissionDate, float gpa, int year){
        super(name, email,  age, gender, location, degree, languages, skills);
        this.admissionDate = admissionDate;
        this.year = year;
        this.gpa = gpa;
    }
    public Student(StudentCreationRequest req){
        super(req.getName(), req.getEmail(),  req.getAge(), req.getGender(), req.getLocation(), req.getDegree(), req.getLanguages(), req.getSkills());
        this.admissionDate = req.getAdmissionDate();
        this.year = req.getYear();
        this.gpa = req.getGpa();
    }

    public void edit(StudentCreationRequest req){
        setName(req.getName());
        setEmail(req.getEmail());
        setAge(req.getAge());
        setGender(req.getGender());
        setLocation(req.getLocation());
        setDegree(req.getDegree());
        setLanguages(req.getLanguages());
        setSkills(req.getSkills());
        this.admissionDate = req.getAdmissionDate();
        this.year = req.getYear();
        this.gpa = req.getGpa();
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
