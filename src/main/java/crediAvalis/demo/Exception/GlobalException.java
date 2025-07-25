package crediAvalis.demo.Exception;

import crediAvalis.demo.dto.authDtos.DtoResponseWithError;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<DtoResponseWithError> missingServletRequestParameterException(MissingServletRequestParameterException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DtoResponseWithError(
                "Error. Make sure you provide the required data",HttpStatus.BAD_REQUEST.value()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DtoResponseWithError> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DtoResponseWithError("Error. Make sure you provide the required data",HttpStatus.BAD_REQUEST.value())
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
