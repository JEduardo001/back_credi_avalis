package crediAvalis.demo.exception.customException;

public class NotSamePasswordException extends RuntimeException{
    public NotSamePasswordException(String message){
        super(message);
    }
}
