package crediAvalis.demo.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;

    private Double amountPaid;
    private LocalDate paymentDate;

    @ManyToOne()
    @JoinColumn(name = "id_credit_obtained")
    private CreditsObtained creditsObtained;

    public Payment() {
    }

    public Payment(Double amountPaid, LocalDate paymentDate, CreditsObtained creditsObtained) {
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.creditsObtained = creditsObtained;
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
        return creditsObtained;
    }

    public void setCreditsObtained(CreditsObtained creditsObtained) {
        this.creditsObtained = creditsObtained;
    }



}
