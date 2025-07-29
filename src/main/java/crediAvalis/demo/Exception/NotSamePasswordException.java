package crediAvalis.demo.Exception;

public class NotSamePasswordException extends RuntimeException{
    public NotSamePasswordException(String message){
        super(message);
    }
}
