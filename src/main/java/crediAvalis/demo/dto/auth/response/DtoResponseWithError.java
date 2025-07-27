package crediAvalis.demo.dto.auth.response;

public class DtoResponseWithError {
    private String message;
    private int stauts;

    public DtoResponseWithError(String message,int status){
        this.message = message;
        this.stauts = status;
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

}

