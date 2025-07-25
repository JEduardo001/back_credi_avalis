package crediAvalis.demo.controller;

import crediAvalis.demo.dto.authDtos.DtoLoginResponse;
import crediAvalis.demo.dto.authDtos.DtoRegisterRequest;
import crediAvalis.demo.dto.authDtos.DtoRegisterResponse;
import crediAvalis.demo.dto.authDtos.DtoResponseLogin;
import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.security.JwtUtil;
import crediAvalis.demo.service.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private final PasswordEncoder passwordEncoder;


    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;

    }

    @PostMapping("/login")
    public ResponseEntity<DtoLoginResponse> login(@RequestParam String username, @RequestParam String password) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        String token = jwtUtil.generateToken(username);
        return ResponseEntity.status(HttpStatus.OK).body(new DtoLoginResponse(
                "Logged in user",HttpStatus.OK.value(),token
        ));
    }

    @PostMapping("/register")
    public ResponseEntity<DtoRegisterResponse> register(@Valid @RequestBody DtoRegisterRequest request) {
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DtoRegisterResponse(
                "Registered User",HttpStatus.CREATED.value(),user.getId(),user.getUsername()
        ));
    }
}
