package app.Backend_USAM.controllers.Request;

import app.Backend_USAM.util.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    public String name;
    public String email;
    public String password;
    public int age;
    public String title;
    public Role role;
}
