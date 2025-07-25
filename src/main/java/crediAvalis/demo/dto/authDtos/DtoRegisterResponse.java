package crediAvalis.demo.dto.authDtos;

public class DtoRegisterResponse {
    private String message;
    private int stauts;
    private int id;
    private String username;


    public DtoRegisterResponse(String message,int status,int id, String username){
        this.message = message;
        this.stauts = status;
        this.id = id;
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
