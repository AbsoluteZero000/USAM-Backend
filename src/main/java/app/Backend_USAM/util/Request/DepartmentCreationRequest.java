package app.Backend_USAM.util.Request;

import java.sql.Date;

public class DepartmentCreationRequest {
    private String name;
    private Date startDate;
    private int ownerId;
    private String depDetails;
    private int studentCapacity;
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
    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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
