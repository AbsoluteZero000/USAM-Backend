package app.Backend_USAM.controllers.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import app.Backend_USAM.entities.User;
import app.Backend_USAM.entities.Repositories.UserRepo;
import app.Backend_USAM.util.enums.Degree;
import app.Backend_USAM.util.enums.Gender;
import app.Backend_USAM.util.enums.Role;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataPopulator implements ApplicationRunner{

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("admin", "admin", 18, Gender.Male, "Giza", Degree.BCS, null, null, null, "admin", Role.ADMIN);
        user.setPassword(passwordEncoder.encode("admin"));
        userRepo.save(user);
        System.out.println(System.currentTimeMillis());
    }

}
