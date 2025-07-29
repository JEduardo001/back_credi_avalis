package crediAvalis.demo.service;

import crediAvalis.demo.Exception.NotFoundRoleToAssignationException;
import crediAvalis.demo.Exception.NotSamePasswordException;
import crediAvalis.demo.dto.auth.request.DtoRegisterRequest;
import crediAvalis.demo.dto.auth.response.DtoRegisterResponse;
import crediAvalis.demo.entities.Role;
import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.projection.interfaceProjection.UserInterfaceProjection;
import crediAvalis.demo.repository.RoleRepository;
import crediAvalis.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser(DtoRegisterRequest dataNewUser){
        validSamePassword(dataNewUser.getPassword(), dataNewUser.getPasswordRepeat());

        UserEntity user = new UserEntity();
        user.setUsername(dataNewUser.getUsername());
        user.setPassword(passwordEncoder.encode(dataNewUser.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new NotFoundRoleToAssignationException("Not found role to assignation to user"));
        user.setRoles(Set.of(role));

        return userRepository.save(user);
    }

    public void validSamePassword(String password,String passwordRepeat){
        if(!password.equals(passwordRepeat)){
             throw new NotSamePasswordException("The passwords do not match");
        }
    }

    public UserInterfaceProjection getDataUser(Integer idUser){
        UserInterfaceProjection user = userRepository.findProjectedById(idUser)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        return user;
    }

}
