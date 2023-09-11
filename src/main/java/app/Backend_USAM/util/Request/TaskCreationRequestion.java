package app.Backend_USAM.util.Request;

import java.sql.Date;
import java.util.ArrayList;

import app.Backend_USAM.util.enums.Skill;

public class TaskCreationRequestion {
    private String name;
    private String duration;
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
    public int getProfid() {
        return profid;
    }
    public void setProfid(int profid) {
        this.profid = profid;
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
    private int profid;
    private Date startDate;
    private int members;
    private ArrayList<Skill> skills;
    private String taskInformation;
}
