package crediAvalis.demo.dto.authDtos;

public class DtoLoginResponse {
    private String message;
    private int status;
    private String token;


    public DtoLoginResponse(String message,int status,String token){
        this.message = message;
        this.status = status;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
