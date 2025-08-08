package crediAvalis.demo.projection.interfaceProjection;

import crediAvalis.demo.entities.RoleEntity;

import java.util.List;
import java.util.Set;

public interface UserInterfaceProjection {

    Integer getId();
    String getUsername();
    String getEmail();
    List<RoleEntity> getRoles();
    Set<CreditObtainedProjection> getCreditsObtained();
    Set<CreditApplicationInterfaceProjection> getListCreditsApplication();
}
