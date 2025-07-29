package crediAvalis.demo.dto.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class DtoRegisterRequest {
    @NotNull
    private String username;
    @NotNull
    @Length(min = 8, max = 25)
    private String password;
    @NotNull
    @Length(min = 8, max = 25)
    private String passwordRepeat;
    @NotNull
    private String fullName;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String birthDate;
    @NotNull
    private String rfc;

    public DtoRegisterRequest(String username, String password,String passwordRepeat){
        this.username = username;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }
}
