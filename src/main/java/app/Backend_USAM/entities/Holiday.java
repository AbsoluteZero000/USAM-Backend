package app.Backend_USAM.entities;

import java.sql.Date;

import app.Backend_USAM.util.Request.HolidayCreationRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="holiday")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Date startDate;
    private Date endDate;
    private String type;

    private Holiday(){}

    public Holiday(String name, Date startDate, Date endDate, String type){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public Holiday(HolidayCreationRequest req){
        edit(req);
    }

    public void edit(HolidayCreationRequest req){
        this.name = req.getName();
        this.startDate = req.getStartDate();
        this.endDate = req.getEndDate();
        this.type = req.getType();
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
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
