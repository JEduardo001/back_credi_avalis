package crediAvalis.demo.Exception;

import crediAvalis.demo.dto.auth.response.DtoResponseWithError;
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

    @ExceptionHandler(NotFoundRoleToAssignationException.class)
    public ResponseEntity<DtoResponseWithError> notFoundRoleToAssignationException(NotFoundRoleToAssignationException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DtoResponseWithError(
                "Error: " + ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value()
        ));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<DtoResponseWithError> missingServletRequestParameterException(MissingServletRequestParameterException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DtoResponseWithError(
                "Error. Make sure you provide the required data",HttpStatus.BAD_REQUEST.value()
        ));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DtoResponseWithError> noSuchElementException(NoSuchElementException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DtoResponseWithError(
                ex.getMessage(),HttpStatus.BAD_REQUEST.value()
        ));
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DtoResponseWithError> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DtoResponseWithError("Error. Make sure you provide the required data",HttpStatus.BAD_REQUEST.value())
        );
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<DtoResponseWithError> methodArgumentNotValidException(UsernameNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DtoResponseWithError("Error: The user with the username granted was not found",HttpStatus.BAD_REQUEST.value())
        );
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<DtoResponseWithError> badCredentialsException(BadCredentialsException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DtoResponseWithError("Error: The user with the granted credentials was not found",HttpStatus.BAD_REQUEST.value())
        );
    }

    @ExceptionHandler(NotSamePasswordException.class)
    public ResponseEntity<DtoResponseWithError> badCredentialsException(NotSamePasswordException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DtoResponseWithError("Error: The passwords do not match",HttpStatus.BAD_REQUEST.value())
        );
    }

    @ExceptionHandler(java.lang.Exception.class)
    public ResponseEntity<DtoResponseWithError> generalException(java.lang.Exception ex){
        ex.getStackTrace();
        System.out.println("Error unknow: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DtoResponseWithError("Error unknow",HttpStatus.INTERNAL_SERVER_ERROR.value())
        );
    }

}
