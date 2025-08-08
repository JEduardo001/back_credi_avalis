package crediAvalis.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String password;
    private String fullName;
    private String rfc;
    private LocalDate birthDate;
    private int creditsApplication;
    private int creditApproved;
    private LocalDate registredDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roleEntities = new HashSet<>();
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<CreditsObtainedEntity> creditsObtainedEntity;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<CreditApplicationEntity> listCreditsApplication = new HashSet<>();

    public Set<RoleEntity> getRoles() {
        return roleEntities;
    }

    public void setRoles(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CreditsObtainedEntity> getCreditsObtained() {
        return creditsObtainedEntity;
    }

    public void setCreditsObtained(CreditsObtainedEntity creditsObtainedEntity) {
        this.creditsObtainedEntity.add(creditsObtainedEntity);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setCreditApproved(int creditApproved) {
        this.creditApproved = creditApproved;
    }

    public int getCreditsApplication() {
        return creditsApplication;
    }

    public void setCreditsApplication(int creditsApplication) {
        this.creditsApplication = creditsApplication;
    }

    public int getCreditApproved() {
        return creditApproved;
    }

    public void setRegistredDate(LocalDate registredDate) {
        this.registredDate = registredDate;
    }

    public LocalDate getRegistredDate() {
        return registredDate;
    }

    public Set<CreditApplicationEntity> getListCreditsApplication() {
        return listCreditsApplication;
    }

    public void setListCreditsApplication(Set<CreditApplicationEntity> listCreditsApplication) {
        this.listCreditsApplication = listCreditsApplication;
    }
}

