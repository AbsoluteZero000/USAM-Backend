package app.Backend_USAM.controllers.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import app.Backend_USAM.entities.User;
import app.Backend_USAM.controllers.Exceptions.AdminSignUpException;
import app.Backend_USAM.controllers.Request.LogInRequest;
import app.Backend_USAM.controllers.Request.SignUpRequest;
import app.Backend_USAM.controllers.Response.AuthenticationResponse;
import app.Backend_USAM.controllers.config.JwtService;
import app.Backend_USAM.entities.Repositories.UserRepo;
import app.Backend_USAM.util.enums.Role;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService service;
    private final AuthenticationManager authManager;



    public AuthenticationResponse register(SignUpRequest req) throws AdminSignUpException {
        if (req.role == Role.ADMIN)
            throw new AdminSignUpException("Can't Sign up as admin");
        req.password = passwordEncoder.encode(req.password);
        User user = new User(req);
        user.setRole(Role.STUDENT);

        userRepo.save(user);
        var jwtToken = service.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(LogInRequest req) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(req.email, req.password));
        User user = userRepo.findByEmail(req.email).orElseThrow();
        var jwtToken = service.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}
