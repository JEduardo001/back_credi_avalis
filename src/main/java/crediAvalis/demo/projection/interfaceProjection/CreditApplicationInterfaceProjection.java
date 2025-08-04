package crediAvalis.demo.projection.interfaceProjection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import crediAvalis.demo.entities.CreditEntity;
import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.enums.CreditApplicationStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

public interface CreditApplicationInterfaceProjection {
    Integer getId();
    String getName();
    Double getAmountRequested();
    Integer getMonthsToPay();
    Double getInterestRate();
    CreditApplicationStatus getStatus();
    LocalDate getCreatedAt();
    CreditProjection getCredit();
    UserDataProjectionToCreditApplication getUser();
}

