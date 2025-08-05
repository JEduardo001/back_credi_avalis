package crediAvalis.demo.dto.credit;

import crediAvalis.demo.dto.user.DtoUser;
import crediAvalis.demo.entities.CreditEntity;
import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.enums.CreditApplicationStatus;
import crediAvalis.demo.projection.interfaceProjection.UserDataProjectionToCreditApplication;
import org.apache.catalina.User;

import java.time.LocalDate;

public class DtoCreditApplicationFilterResponse {
    private Integer id;
    private String name;
    private Double amountRequested;
    private Integer monthsToPay;
    private Double interestRate;
    private CreditApplicationStatus status;
    private LocalDate createdAt;
    private CreditEntity credit;
    private UserEntity user;

    public DtoCreditApplicationFilterResponse(Integer id, String name, Double amountRequested, Integer monthsToPay,
                                              Double interestRate, CreditApplicationStatus status,
                                              LocalDate createdAt, CreditEntity credit, UserEntity user) {
        this.id = id;
        this.name = name;
        this.amountRequested = amountRequested;
        this.monthsToPay = monthsToPay;
        this.interestRate = interestRate;
        this.status = status;
        this.createdAt = createdAt;
        this.credit = credit;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public CreditEntity getCredit() {
        return credit;
    }

    public void setCredit(CreditEntity credit) {
        this.credit = credit;
    }

    public DtoUser getUser() {
        return new DtoUser(
                this.user.getId(),
                this.user.getUsername(),
                this.user.getEmail(),
                this.user.getPassword(),
                this.user.getFullName(),
                this.user.getRfc(),
                this.user.getBirthDate(),
                this.user.getCreditsApplication(),
                this.user.getCreditApproved(),
                this.user.getRegistredDate()
        );
    }


    public void setUser(UserEntity user) {
        this.user = user;
    }
}
