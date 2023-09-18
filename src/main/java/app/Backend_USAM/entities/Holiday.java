package app.Backend_USAM.entities;

import java.sql.Date;

import app.Backend_USAM.controllers.Request.CreationRequest.HolidayCreationRequest;
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
@Table(name = "holidays")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Date startDate;
    private Date endDate;
    private String type;


    public Holiday(HolidayCreationRequest req){
        edit(req);
    }
    public void edit(HolidayCreationRequest req){
        this.name = req.getName();
        this.startDate = req.getStartDate();
        this.endDate = req.getEndDate();
        this.type = req.getType();
    }
}
