package crediAvalis.demo.dto.auth;

public class DtoResponseWithoutData {
    private String message;
    private int status;

    public DtoResponseWithoutData(String message, int status){
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStauts() {
        return status;
    }

    public void setStauts(int stauts) {
        this.status = stauts;
    }

}

