package crediAvalis.demo.projection.interfaceProjection;

import crediAvalis.demo.entities.Payment;
import crediAvalis.demo.enums.CreditApplicationStatus;

import java.time.LocalDate;
import java.util.List;

public interface CreditObtainedProjection {
    Integer getId();
    String getName();
    boolean getCreditFinishedPaying();
    Double getAmountPaid();
    Double getAmountToPay();
    Integer getMonthsToPay();
    Double getInterestRate();
    LocalDate getAprovedDate();
    CreditProjection getCredit();
    List<PaymentProjection> getPayments();
}
