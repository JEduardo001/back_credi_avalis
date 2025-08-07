package crediAvalis.demo.Exception;

import crediAvalis.demo.dto.auth.DtoResponseWithoutData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(NotFoundCreditObtainedException.class)
    public ResponseEntity<DtoResponseWithoutData> notFoundCreditObtainedException(NotFoundCreditObtainedException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DtoResponseWithoutData(
                "Error: The credit obtained was not found",HttpStatus.NOT_FOUND.value()
        ));
    }
    @ExceptionHandler(NotFoundRoleToAssignationException.class)
    public ResponseEntity<DtoResponseWithoutData> notFoundRoleToAssignationException(NotFoundRoleToAssignationException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DtoResponseWithoutData(
                "Error: " + ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value()
        ));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<DtoResponseWithoutData> missingServletRequestParameterException(MissingServletRequestParameterException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DtoResponseWithoutData(
                "Error. Make sure you provide the required data",HttpStatus.BAD_REQUEST.value()
        ));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DtoResponseWithoutData> noSuchElementException(NoSuchElementException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DtoResponseWithoutData(
                ex.getMessage(),HttpStatus.BAD_REQUEST.value()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DtoResponseWithoutData> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DtoResponseWithoutData("Error. Make sure you provide the required data in correct format and correct specifications",HttpStatus.BAD_REQUEST.value())
        );
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<DtoResponseWithoutData> userAlreadyExistsException(UserAlreadyExistsException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DtoResponseWithoutData(ex.getMessage(), HttpStatus.BAD_REQUEST.value())
        );
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<DtoResponseWithoutData> methodArgumentNotValidException(UsernameNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DtoResponseWithoutData("Error: The user with the username granted was not found",HttpStatus.NOT_FOUND.value())
        );
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<DtoResponseWithoutData> badCredentialsException(BadCredentialsException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DtoResponseWithoutData("Error: The user with the granted credentials was not found",HttpStatus.BAD_REQUEST.value())
        );
    }

    @ExceptionHandler(NotFoundCreditApplication.class)
    public ResponseEntity<DtoResponseWithoutData> notFoundCreditApplication(NotFoundCreditApplication ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DtoResponseWithoutData("Erro. Not found credit application",HttpStatus.NOT_FOUND.value())
        );
    }

    @ExceptionHandler(EmptyDataException.class)
    public ResponseEntity<DtoResponseWithoutData> emptyDataException(EmptyDataException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DtoResponseWithoutData("Error: The information cannot be empty",HttpStatus.BAD_REQUEST.value())
        );
    }


    @ExceptionHandler(NotSamePasswordException.class)
    public ResponseEntity<DtoResponseWithoutData> badCredentialsException(NotSamePasswordException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DtoResponseWithoutData("Error: The passwords do not match",HttpStatus.BAD_REQUEST.value())
        );
    }

    @ExceptionHandler(java.lang.Exception.class)
    public ResponseEntity<DtoResponseWithoutData> generalException(java.lang.Exception ex){
        ex.getStackTrace();
        System.out.println("Error unknow: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DtoResponseWithoutData("Error unknow",HttpStatus.INTERNAL_SERVER_ERROR.value())
        );
    }

}
