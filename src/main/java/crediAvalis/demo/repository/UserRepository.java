package crediAvalis.demo.repository;

import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.enums.CreditApplicationStatus;
import crediAvalis.demo.projection.interfaceProjection.CreditApplicationInterfaceProjection;
import crediAvalis.demo.projection.interfaceProjection.UserDataProjectionToCreditApplication;
import crediAvalis.demo.projection.interfaceProjection.UserInterfaceProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findById(Integer id);
    Optional<UserDataProjectionToCreditApplication>  findProjectedById(Integer id);
    Optional<UserInterfaceProjection>  findProjectedByUsername(String id);

}
