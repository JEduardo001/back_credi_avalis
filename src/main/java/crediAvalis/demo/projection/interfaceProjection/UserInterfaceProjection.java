package crediAvalis.demo.projection.interfaceProjection;

import crediAvalis.demo.entities.CreditApplication;
import crediAvalis.demo.entities.CreditsObtained;
import crediAvalis.demo.entities.Role;

import java.util.List;
import java.util.Set;

public interface UserInterfaceProjection {

    Integer getId();
    String getUsername();
    String getEmail();
    List<Role> getRoles();
    Set<CreditsObtained> getCreditsObtained();
    Set<CreditApplication> getListCreditsApplication();


}
