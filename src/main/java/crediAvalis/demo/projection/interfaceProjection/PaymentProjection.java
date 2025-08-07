package crediAvalis.demo.projection.interfaceProjection;

import crediAvalis.demo.enums.PaymentCreditObtainedStatus;

import java.time.LocalDate;

public interface PaymentProjection {
    Integer getId();
    Double getAmountPaid();
    LocalDate getPaymentDate();
    PaymentCreditObtainedStatus getStatus();
}
