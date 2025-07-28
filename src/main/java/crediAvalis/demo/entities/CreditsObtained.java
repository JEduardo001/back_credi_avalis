package crediAvalis.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CreditsObtained {
    @Id
    @GeneratedValue
    private Integer id;
    private Double amountPaid;
    private Integer monthsToPay;
    private Double interestRate;
    private LocalDate aprovedDate;
    @ManyToOne
    @JoinColumn(name = "id_credit")
    private CreditEntity credit;
    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private UserEntity user;
    @OneToMany(mappedBy = "creditObtained")
    private List<Payment> payments;

    public CreditsObtained(){}

    public CreditsObtained(Double amountPaid, Integer monthsToPay, Double interestRate, LocalDate applicationDate, CreditEntity credit, UserEntity user) {
        this.amountPaid = amountPaid;
        this.monthsToPay = monthsToPay;
        this.interestRate = interestRate;
        this.aprovedDate = applicationDate;
        this.credit = credit;
        this.user = user;
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

    public LocalDate getAprovedDate() {
        return aprovedDate;
    }

    public void setAprovedDate(LocalDate applicationDate) {
        this.aprovedDate = applicationDate;
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

    public UserEntity getUser() {
        return user;
    }

    public void setPayment(Payment payments) {
        this.payments.add(payments);
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
