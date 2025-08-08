package crediAvalis.demo.repository;

import crediAvalis.demo.entities.CreditsObtainedEntity;
import crediAvalis.demo.projection.interfaceProjection.CreditObtainedProjection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditsObtainedRepository extends JpaRepository<CreditsObtainedEntity,Integer> {
    CreditObtainedProjection findProjectionById(Integer idCreditObtainer);
}
