package crediAvalis.demo.entities;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;

    private Double amountPaid;
    private LocalDateTime paymentDate;

    @ManyToOne
    private CreditApplication credit;

}
