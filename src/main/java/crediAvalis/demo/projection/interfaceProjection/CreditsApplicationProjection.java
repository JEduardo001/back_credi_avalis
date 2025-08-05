package crediAvalis.demo.projection.interfaceProjection;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import crediAvalis.demo.entities.CreditApplication;
import crediAvalis.demo.entities.CreditEntity;
import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.enums.CreditApplicationStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public interface CreditsApplicationProjection {
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

