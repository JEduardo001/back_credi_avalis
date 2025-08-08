package crediAvalis.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CreditsObtainedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double amountPaid;
    private Double amountToPay;
    private boolean creditFinishedPaying;
    private String name;
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
    @JsonManagedReference
    private List<PaymentEntity> paymentEntities;

    public CreditsObtainedEntity(){}

    public CreditsObtainedEntity(Double amountPaid, Double amountToPay, Boolean creditFinishedPaying, String name, Integer monthsToPay, Double interestRate, LocalDate applicationDate, CreditEntity credit, UserEntity user) {
        this.amountPaid = amountPaid;
        this.amountToPay = amountToPay;
        this.creditFinishedPaying = creditFinishedPaying;
        this.name = name;
        this.monthsToPay = monthsToPay;
        this.interestRate = interestRate;
        this.aprovedDate = applicationDate;
        this.credit = credit;
        this.user = user;
    }


    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setPayment(PaymentEntity payments) {
        this.paymentEntities.add(payments);
    }

    public List<PaymentEntity> getPayments() {
        return paymentEntities;
    }

    public Double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(Double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public void setPayments(List<PaymentEntity> paymentEntities) {
        this.paymentEntities = paymentEntities;
    }

    public void setCreditFinishedPaying(boolean creditFinishedPaying) {
        this.creditFinishedPaying = creditFinishedPaying;
    }

    public boolean getCreditFinishedPaying(){
        return creditFinishedPaying;
    }
}
