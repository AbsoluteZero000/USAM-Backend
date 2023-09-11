package app.Backend_USAM.entities;

import java.sql.Date;
import java.util.ArrayList;

import app.Backend_USAM.util.Request.TaskCreationRequestion;
import app.Backend_USAM.util.enums.Skill;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String duration;
    //Many to One relationship with staff
    private int proffessor;
    private Date startDate;
    private int members;
    private ArrayList<Skill> skills;
    private String taskInformation;
    public Task(TaskCreationRequestion req){
        edit(req);
    }

    public void edit(TaskCreationRequestion req){
        this.name = req.getName();
        this.duration = req.getDuration();
        this.startDate = req.getStartDate();
        this.members = req.getMembers();
        this.skills = req.getSkills();
        this.taskInformation = req.getTaskInformation();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public int getProffessor() {
        return proffessor;
    }
    public void setProffessor(int proffessor) {
        this.proffessor = proffessor;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public int getMembers() {
        return members;
    }
    public void setMembers(int members) {
        this.members = members;
    }
    public ArrayList<Skill> getSkills() {
        return skills;
    }
    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
    public String getTaskInformation() {
        return taskInformation;
    }
    public void setTaskInformation(String taskInformation) {
        this.taskInformation = taskInformation;
    }

}
