package crediAvalis.demo.repository;

import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.projection.interfaceProjection.UserInterfaceProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserInterfaceProjection>  findProjectedById(Integer id);
}
