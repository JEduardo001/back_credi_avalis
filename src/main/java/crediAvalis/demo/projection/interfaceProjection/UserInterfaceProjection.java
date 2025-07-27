package crediAvalis.demo.projection.interfaceProjection;

import crediAvalis.demo.entities.Role;

import java.util.List;

public interface UserInterfaceProjection {

    Integer getId();
    String getUsername();
    String getEmail();
    List<Role> getRoles();


}
