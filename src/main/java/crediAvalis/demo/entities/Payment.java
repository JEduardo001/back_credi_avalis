package crediAvalis.demo.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amountPaid;
    private LocalDate paymentDate;

    @ManyToOne()
    @JoinColumn(name = "id_credit_obtained")
    @JsonBackReference
    private CreditsObtained creditObtained;

    public Payment() {
    }

    public Payment(Double amountPaid, LocalDate paymentDate, CreditsObtained creditObtained) {
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.creditObtained = creditObtained;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public CreditsObtained getCreditsObtained() {
        return creditObtained;
    }

    public void setCreditsObtained(CreditsObtained creditsObtained) {
        this.creditObtained = creditsObtained;
    }



}
