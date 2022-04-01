package carparking.exceptionHandle;
import carparking.convertor.Convertor;
import carparking.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationFailed(MethodArgumentNotValidException exception){
        ApiError apiError = Convertor.errors(exception.getFieldErrors());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> missingJsonBody(HttpMessageNotReadableException exception){
        Map<String,String> map= new HashMap<>();
        map.put("error","Invalid request missing Json Body ");
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> usernameNotFound(UsernameNotFoundException exception){
      ApiError apiError = new ApiError();
      apiError.setMessage(exception.getMessage());
      apiError.setStatus(Boolean.FALSE);
      apiError.setHttpStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> badCredentialsException(BadCredentialsException exception){
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setStatus(Boolean.FALSE);
        apiError.setHttpStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiError,HttpStatus.OK);
    }
}
