package app.Backend_USAM.entities;

import java.sql.Date;
import app.Backend_USAM.util.Request.DepartmentCreationRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff head;

    private String depDetails;
    private int studentCapacity;

    private Department(){}

    public Department(DepartmentCreationRequest req){
        edit(req);

    }

    public void edit(DepartmentCreationRequest req){
        this.name = req.getName();
        this.startDate = req.getStartDate();
        this.depDetails = req.getDepDetails();
        this.studentCapacity = req.getStudentCapacity();
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
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Staff getHead() {
        return head;
    }
    public void setHead(Staff head) {
        this.head = head;
    }
    public String getDepDetails() {
        return depDetails;
    }
    public void setDepDetails(String depDetails) {
        this.depDetails = depDetails;
    }
    public int getStudentCapacity() {
        return studentCapacity;
    }
    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

}
