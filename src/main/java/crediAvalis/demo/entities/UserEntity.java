package crediAvalis.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
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
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<CreditsObtained> creditsObtained = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public Set<CreditsObtained> getCreditsObtained() {
        return creditsObtained;
    }

    public void setCreditsObtained(Set<CreditsObtained> creditsObtained) {
        this.creditsObtained = creditsObtained;
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
}

