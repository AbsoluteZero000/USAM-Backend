package app.Backend_USAM.controllers.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import app.Backend_USAM.controllers.Exception.AdminSignUpException;
import app.Backend_USAM.controllers.Request.LogInRequest;
import app.Backend_USAM.controllers.Request.SignUpRequest;
import app.Backend_USAM.controllers.Response.AuthenticationResponse;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LogInRequest req) {

        return ResponseEntity.ok(service.authenticate(req));
    }
    @PostMapping("signup")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody SignUpRequest req) throws AdminSignUpException {
        return ResponseEntity.ok(service.register(req));

    }
    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, StreamWriteException, DatabindException, java.io.IOException {
        service.refreshToken(request, response);
    }


}
