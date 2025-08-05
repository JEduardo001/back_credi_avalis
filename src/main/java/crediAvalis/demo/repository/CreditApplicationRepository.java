package crediAvalis.demo.repository;

import crediAvalis.demo.entities.CreditApplication;
import crediAvalis.demo.enums.CreditApplicationStatus;
import crediAvalis.demo.projection.interfaceProjection.CreditApplicationInterfaceProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication,Integer> {
    Page<CreditApplicationInterfaceProjection> findAllProjectedBy(Pageable page);
    Page<CreditApplicationInterfaceProjection> findAllByStatus(CreditApplicationStatus status, Pageable page);

    @Query("SELECT c FROM CreditApplication c WHERE c.status = :filter")
    Page<CreditApplicationInterfaceProjection> findAllProjectedByFilter(@Param("filter") CreditApplicationStatus filter, Pageable page);


}
