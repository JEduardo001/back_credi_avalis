package crediAvalis.demo.service;

import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserEntity createUser(UserEntity newUser){
        return userRepository.save(newUser);
    }
}
