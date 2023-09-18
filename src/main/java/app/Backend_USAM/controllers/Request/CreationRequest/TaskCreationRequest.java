package app.Backend_USAM.controllers.Request.CreationRequest;

import java.sql.Date;
import java.util.ArrayList;

import app.Backend_USAM.util.enums.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreationRequest {
    private String name;
    private String duration;
    private int professorId;
    private Date startDate;
    private int members;
    private ArrayList<Skill> skills;
    private String taskInformation;
}
