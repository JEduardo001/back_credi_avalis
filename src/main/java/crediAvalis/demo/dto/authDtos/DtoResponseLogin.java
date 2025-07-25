package crediAvalis.demo.dto.authDtos;

public class DtoResponseLogin {
    private String message;
    private int stauts;
    private String token;

    public DtoResponseLogin(String message,int status, String token){
        this.message = message;
        this.stauts = status;
        this.token = token;
    }

}
