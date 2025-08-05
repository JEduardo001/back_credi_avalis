package crediAvalis.demo.dto.user;

import java.time.LocalDate;

public class DtoUser {
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

    public DtoUser(Integer id, String username, String email, String password, String fullName,
                           String rfc, LocalDate birthDate, int creditsApplication,
                           int creditApproved, LocalDate registredDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.rfc = rfc;
        this.birthDate = birthDate;
        this.creditsApplication = creditsApplication;
        this.creditApproved = creditApproved;
        this.registredDate = registredDate;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public int getCreditsApplication() { return creditsApplication; }
    public void setCreditsApplication(int creditsApplication) { this.creditsApplication = creditsApplication; }

    public int getCreditApproved() { return creditApproved; }
    public void setCreditApproved(int creditApproved) { this.creditApproved = creditApproved; }

    public LocalDate getRegistredDate() { return registredDate; }
    public void setRegistredDate(LocalDate registredDate) { this.registredDate = registredDate; }

}
