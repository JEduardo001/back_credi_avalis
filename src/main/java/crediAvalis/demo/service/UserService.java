package crediAvalis.demo.service;

import crediAvalis.demo.Exception.EmptyDataException;
import crediAvalis.demo.Exception.NotFoundRoleToAssignationException;
import crediAvalis.demo.Exception.NotSamePasswordException;
import crediAvalis.demo.Exception.UserAlreadyExistsException;
import crediAvalis.demo.dto.auth.request.DtoRegisterRequest;
import crediAvalis.demo.dto.auth.response.DtoRegisterResponse;
import crediAvalis.demo.entities.Role;
import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.projection.interfaceProjection.UserDataProjectionToCreditApplication;
import crediAvalis.demo.projection.interfaceProjection.UserInterfaceProjection;
import crediAvalis.demo.repository.RoleRepository;
import crediAvalis.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;

import java.time.LocalDate;
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
        validEmptyData(dataNewUser);
        validSamePassword(dataNewUser.getPassword(), dataNewUser.getPasswordRepeat());

        userRepository.findByUsername(dataNewUser.getUsername())
                .ifPresent(user -> {
                    throw new UserAlreadyExistsException("Error. Username is now in use.");
                });

        userRepository.findByEmail(dataNewUser.getEmail())
                .ifPresent(user -> {
                    throw new UserAlreadyExistsException("Error. Email is now in use");
                });

        LocalDate birthDate = LocalDate.parse(dataNewUser.getBirthDate());

        UserEntity user = new UserEntity();
        user.setUsername(dataNewUser.getUsername());
        user.setFullName(dataNewUser.getFullName());
        user.setPassword(passwordEncoder.encode(dataNewUser.getPassword()));
        user.setBirthDate(birthDate);
        user.setRfc(dataNewUser.getRfc());
        user.setEmail(dataNewUser.getEmail());
        user.setCreditApproved(0);
        user.setCreditsApplication(0);
        user.setRegistredDate(LocalDate.now());

        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new NotFoundRoleToAssignationException("Not found role to assignation to user"));
        user.setRoles(Set.of(role));

        return userRepository.save(user);
    }

    public UserInterfaceProjection getDataUser(Integer idUser){
        UserInterfaceProjection user = userRepository.findProjectedById(idUser)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        return user;
    }


    public UserDataProjectionToCreditApplication getDataUserAllData(Integer idUser){
        UserDataProjectionToCreditApplication user = userRepository.findToShowAllData(idUser)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return user;
    }


    public UserInterfaceProjection getDataUserByUsername(String username){
        UserInterfaceProjection user = userRepository.findProjectedByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        return user;
    }

    public void validSamePassword(String password,String passwordRepeat){
        if(!password.equals(passwordRepeat)){
            throw new NotSamePasswordException("The passwords do not match");
        }
    }

    public void validEmptyData(DtoRegisterRequest dataNewUser) {
        if (isEmpty(dataNewUser.getFullName()) ||
                isEmpty(dataNewUser.getUsername()) ||
                isEmpty(dataNewUser.getEmail()) ||
                isEmpty(dataNewUser.getPassword()) ||
                isEmpty(dataNewUser.getPasswordRepeat()) ||
                isEmpty(dataNewUser.getRfc()) ||
                isEmpty(dataNewUser.getBirthDate())) {

            throw new EmptyDataException();
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }


}
