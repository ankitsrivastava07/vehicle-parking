package carparking.error;
import lombok.Data;

@Data
public class FieldError {
    private String fieldName;
    private Object rejectedValue;
    private String message;
}
