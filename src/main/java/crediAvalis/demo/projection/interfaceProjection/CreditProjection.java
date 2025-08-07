package crediAvalis.demo.projection.interfaceProjection;

public interface CreditProjection {
    Integer getId();
    String getName();
    Double getAmountRequested();
    Integer getMonthsToPay();
    Double getInterestRate();
}
