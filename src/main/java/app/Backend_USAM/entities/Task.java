package app.Backend_USAM.entities;

import java.sql.Date;
import java.util.ArrayList;

import app.Backend_USAM.controllers.Request.CreationRequest.TaskCreationRequest;
import app.Backend_USAM.util.enums.Skill;
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
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String duration;
    private int professorId;
    private Date startDate;
    private int members;
    private ArrayList<Skill> skills;
    private String taskInformation;


    public Task(TaskCreationRequest req){
        edit(req);
    }

    public void edit(TaskCreationRequest req){
        this.name = req.getName();
        this.duration = req.getDuration();
        this.startDate = req.getStartDate();
        this.members = req.getMembers();
        this.skills = req.getSkills();
        this.taskInformation = req.getTaskInformation();
    }
}
