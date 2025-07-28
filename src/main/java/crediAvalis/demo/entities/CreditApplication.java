package crediAvalis.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import crediAvalis.demo.enums.CreditApplicationStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class CreditApplication {
    @Id
    @GeneratedValue
    private Integer id;
    private Double amountRequested;
    private Integer monthsToPay;
    private Double interestRate;
    @Enumerated(EnumType.STRING)
    private CreditApplicationStatus status; // PENDING, APPROVED, REJECTED
    private LocalDate createdAt;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "id_credit")
    private CreditEntity credit;


    public CreditApplication() {
    }

    public CreditApplication(Double amountRequested, Integer monthsToPay, Double interestRate, CreditApplicationStatus status, LocalDate createdAt, UserEntity user, CreditEntity credit) {
        this.amountRequested = amountRequested;
        this.monthsToPay = monthsToPay;
        this.interestRate = interestRate;
        this.status = status;
        this.createdAt = createdAt;
        this.user = user;
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(Double amountRequested) {
        this.amountRequested = amountRequested;
    }

    public Integer getMonthsToPay() {
        return monthsToPay;
    }

    public void setMonthsToPay(Integer monthsToPay) {
        this.monthsToPay = monthsToPay;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public CreditApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(CreditApplicationStatus status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CreditEntity getCredit() {
        return credit;
    }

    public void setCredit(CreditEntity credit) {
        this.credit = credit;
    }


}
