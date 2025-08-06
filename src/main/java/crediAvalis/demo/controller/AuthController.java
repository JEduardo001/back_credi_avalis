package crediAvalis.demo.controller;

import crediAvalis.demo.Exception.NotFoundRoleToAssignationException;
import crediAvalis.demo.dto.auth.DtoResponseWithData;
import crediAvalis.demo.dto.auth.response.DtoLoginResponse;
import crediAvalis.demo.dto.auth.request.DtoRegisterRequest;
import crediAvalis.demo.dto.auth.response.DtoRegisterResponse;
import crediAvalis.demo.entities.Role;
import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.projection.interfaceProjection.UserDataProjectionToCreditApplication;
import crediAvalis.demo.projection.interfaceProjection.UserInterfaceProjection;
import crediAvalis.demo.repository.RoleRepository;
import crediAvalis.demo.security.JwtUtil;
import crediAvalis.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;


    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<DtoLoginResponse> login(@RequestParam String username, @RequestParam String password) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );


        Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
        boolean isAdmin = roles.stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

        UserInterfaceProjection user = userService.getDataUserByUsername(username);

        String token = jwtUtil.generateToken(username);
        return ResponseEntity.status(HttpStatus.OK).body(new DtoLoginResponse(
                "Logged in user",HttpStatus.OK.value(),token,user.getId(),isAdmin
        ));
    }

    @PostMapping("/register")
    public ResponseEntity<DtoRegisterResponse> register(@Valid @RequestBody DtoRegisterRequest request) {
        UserEntity user = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DtoRegisterResponse(
                "Registered User",HttpStatus.CREATED.value(),user.getId(),user.getUsername()
        ));
    }

    @GetMapping("/authData")
    public ResponseEntity<DtoResponseWithData> getUserData(@RequestParam Integer idUser){
        UserInterfaceProjection user = userService.getDataUser(idUser);
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Fetched Data",HttpStatus.OK.value(),user
        ));
    }

    @GetMapping("/getDataUserAllData")
    public ResponseEntity<DtoResponseWithData> getDataUserAllData(@RequestParam Integer idUser){
        UserDataProjectionToCreditApplication user = userService.getDataUserAllData(idUser);
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Fetched Data",HttpStatus.OK.value(),user
        ));
    }
}