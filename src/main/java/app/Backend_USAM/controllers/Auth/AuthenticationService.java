package app.Backend_USAM.controllers.Auth;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import app.Backend_USAM.entities.User;
import app.Backend_USAM.controllers.Exception.AdminSignUpException;
import app.Backend_USAM.controllers.Request.LogInRequest;
import app.Backend_USAM.controllers.Request.SignUpRequest;
import app.Backend_USAM.controllers.Response.AuthenticationResponse;
import app.Backend_USAM.controllers.config.JwtService;
import app.Backend_USAM.entities.Repositories.UserRepo;
import app.Backend_USAM.util.enums.Role;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

    public void refreshToken(HttpServletRequest req, HttpServletResponse res) throws IOException, StreamWriteException, DatabindException, java.io.IOException{
        final String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if(authHeader == null || !authHeader.startsWith("Bearer "))
            return;
        refreshToken = authHeader.substring(7);
        userEmail = service.extractUsername(refreshToken);
        if(userEmail != null){
            User user = userRepo.findByEmail(userEmail).orElseThrow();
            if(service.isTokenValid(refreshToken, user)){
                var accessToken = service.generateToken(user);
                var authResponse = AuthenticationResponse.builder().token(accessToken).build();
                new ObjectMapper().writeValue(res.getOutputStream(), authResponse);
            }
        }
    }


}
