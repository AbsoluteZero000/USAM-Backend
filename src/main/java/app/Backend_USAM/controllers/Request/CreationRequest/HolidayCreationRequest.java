package app.Backend_USAM.controllers.Request.CreationRequest;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
public class HolidayCreationRequest {
    private String name;
    private Date startDate;
    private Date endDate;
    private String type;
}
