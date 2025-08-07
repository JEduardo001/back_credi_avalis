package crediAvalis.demo.repository;

import crediAvalis.demo.entities.CreditsObtained;
import crediAvalis.demo.projection.interfaceProjection.CreditObtainedProjection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditsObtainedRepository extends JpaRepository<CreditsObtained,Integer> {
    CreditObtainedProjection findProjectionById(Integer idCreditObtainer);
}
