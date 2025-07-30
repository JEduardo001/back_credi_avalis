package crediAvalis.demo.dto.auth.response;

public class DtoLoginResponse {
    private String message;
    private int status;
    private String token;
    private int idUser;

    public DtoLoginResponse(String message,int status,String token,int idUser){
        this.message = message;
        this.status = status;
        this.token = token;
        this.idUser = idUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
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
