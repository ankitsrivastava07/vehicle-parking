package carparking.exceptionHandle;
import carparking.convertor.Convertor;
import carparking.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationFailed(MethodArgumentNotValidException exception){
        ApiError apiError = Convertor.errors(exception.getFieldErrors());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
