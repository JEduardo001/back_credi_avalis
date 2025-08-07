package crediAvalis.demo.dto.payment;

import crediAvalis.demo.enums.PaymentCreditObtainedStatus;

import java.time.LocalDate;

public class DtoPayment {
    private Integer id;
    private boolean creditFinishedPaying;
    private Double amountPaid;
    private LocalDate paymentDate;
    private PaymentCreditObtainedStatus status;


    public DtoPayment(Integer id,boolean creditFinishedPaying,Double amountPaid, LocalDate paymentDate, PaymentCreditObtainedStatus status) {
        this.id = id;
        this.creditFinishedPaying = creditFinishedPaying;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public void setCreditFinishedPaying(boolean creditFinishedPaying) {
        this.creditFinishedPaying = creditFinishedPaying;
    }

    public boolean getCreditFinishedPaying(){
        return creditFinishedPaying;
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

    public PaymentCreditObtainedStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentCreditObtainedStatus status) {
        this.status = status;
    }

}
