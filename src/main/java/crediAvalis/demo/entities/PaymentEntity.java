package crediAvalis.demo.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import crediAvalis.demo.enums.PaymentCreditObtainedStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amountPaid;
    private LocalDate paymentDate;
    private PaymentCreditObtainedStatus status;

    @ManyToOne()
    @JoinColumn(name = "id_credit_obtained")
    @JsonBackReference
    private CreditsObtainedEntity creditObtained;

    public PaymentEntity() {
    }

    public PaymentEntity(Double amountPaid, LocalDate paymentDate, PaymentCreditObtainedStatus status, CreditsObtainedEntity creditObtained) {
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.status = status;
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

    public CreditsObtainedEntity getCreditsObtained() {
        return creditObtained;
    }

    public void setCreditsObtained(CreditsObtainedEntity creditsObtainedEntity) {
        this.creditObtained = creditsObtainedEntity;
    }

    public PaymentCreditObtainedStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentCreditObtainedStatus status) {
        this.status = status;
    }

    public void setCreditObtained(CreditsObtainedEntity creditObtained) {
        this.creditObtained = creditObtained;
    }

    public CreditsObtainedEntity getCreditObtained() {
        return creditObtained;
    }
}
