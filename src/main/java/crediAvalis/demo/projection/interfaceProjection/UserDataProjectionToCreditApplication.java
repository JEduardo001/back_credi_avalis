package crediAvalis.demo.projection.interfaceProjection;

import java.time.LocalDate;

public interface UserDataProjectionToCreditApplication {
    Integer getId();
    String getUsername();
    String getEmail();
    String getFullName();
    String getRfc();
    Integer getCreditsApplication();
    Integer getCreditApproved();
    LocalDate getRegistredDate();

}
