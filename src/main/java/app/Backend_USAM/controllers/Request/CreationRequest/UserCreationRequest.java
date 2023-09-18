package app.Backend_USAM.controllers.Request.CreationRequest;

import java.sql.Date;
import java.util.ArrayList;

import app.Backend_USAM.util.enums.Role;
import app.Backend_USAM.util.enums.Degree;
import app.Backend_USAM.util.enums.Gender;
import app.Backend_USAM.util.enums.Language;
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
public class UserCreationRequest {
    private String name;
    private String email;
    private String password;
    private int age;
    private Gender gender;
    private String location;
    private Degree degree;
    private ArrayList<Language> languages;
    private ArrayList<Skill> skills;
    private Date startDate;
    private String title;
    private Role role;


}
