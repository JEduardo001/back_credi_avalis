package crediAvalis.demo.exception.customException;

public class NotFoundRoleToAssignationException extends RuntimeException{
    public NotFoundRoleToAssignationException(String message){
        super(message);
    }
}
