package crediAvalis.demo.dto.authDtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class DtoRegisterRequest {
    @NotNull
    private String username;
    @NotNull
    @Length(min = 8, max = 25)
    private String password;

    public DtoRegisterRequest(String username, String password){
        this.username = username;
        this.password = password;
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
}
