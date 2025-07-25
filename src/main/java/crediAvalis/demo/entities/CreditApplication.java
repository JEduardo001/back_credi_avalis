package crediAvalis.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class CreditApplication {
    @Id
    @GeneratedValue
    private Integer id;

    private Double amountRequested;
    private Integer monthsToPay;
    private Double interestRate;
    private String status; // PENDING, APPROVED, REJECTED

    @ManyToOne
    private UserEntity user;

    private LocalDateTime createdAt;

}
