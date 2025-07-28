package crediAvalis.demo.repository;

import crediAvalis.demo.entities.CreditApplication;
import crediAvalis.demo.enums.CreditApplicationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication,Integer> {
    Page<CreditApplication> findAll(Pageable page);
    Page<CreditApplication> findAllByStatus(CreditApplicationStatus status, Pageable page);
}
