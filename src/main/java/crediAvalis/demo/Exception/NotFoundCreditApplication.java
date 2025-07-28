package crediAvalis.demo.Exception;

public class NotFoundCreditApplication extends RuntimeException{
    public NotFoundCreditApplication(String message){
        super(message);
    }
}
