package crediAvalis.demo.repository;

import crediAvalis.demo.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Integer> {
}
