package app.Backend_USAM.entities;

import java.sql.Date;

import app.Backend_USAM.controllers.Request.CreationRequest.DepartmentCreationRequest;
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
@Setter
@Getter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Date startDate;
    private String depDetails;
    private int studentCapacity;

    public Department(DepartmentCreationRequest req){
        edit(req);
    }

    public void edit(DepartmentCreationRequest req){
        this.name = req.getName();
        this.startDate = req.getStartDate();
        this.depDetails = req.getDepDetails();
        this.studentCapacity = req.getStudentCapacity();
    }
}
