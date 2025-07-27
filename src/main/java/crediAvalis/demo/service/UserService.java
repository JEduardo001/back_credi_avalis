package crediAvalis.demo.service;

import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.projection.interfaceProjection.UserInterfaceProjection;
import crediAvalis.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity newUser){
        return userRepository.save(newUser);
    }

    public UserInterfaceProjection getDataUser(Integer idUser){
        UserInterfaceProjection user = userRepository.findProjectedById(idUser)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        return user;
    }

}
