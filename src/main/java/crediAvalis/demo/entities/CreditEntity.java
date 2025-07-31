package crediAvalis.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double amountRequested;
    private Integer monthsToPay;
    private Double interestRate;
    @OneToMany(mappedBy = "credit")
    @JsonBackReference
    private List<CreditApplication> creditApplication;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setCreditApplication(CreditApplication creditApplication) {
        this.creditApplication.add(creditApplication);
    }

    public List<CreditApplication> getCreditApplication() {
        return creditApplication;
    }
}

