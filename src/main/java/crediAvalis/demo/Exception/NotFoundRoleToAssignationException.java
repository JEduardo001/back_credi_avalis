package crediAvalis.demo.Exception;

public class NotFoundRoleToAssignationException extends RuntimeException{
    public NotFoundRoleToAssignationException(String message){
        super(message);
    }
}
