package crediAvalis.demo.repository;

import crediAvalis.demo.entities.CreditEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CreditRepository extends JpaRepository<CreditEntity,Integer> {

    Page<CreditEntity> findAllBy(Pageable page);
}
