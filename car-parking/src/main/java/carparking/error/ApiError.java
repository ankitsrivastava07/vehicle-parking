package carparking.error;
import lombok.Data;
import java.util.List;

@Data
public class ApiError {
    private String message;
    private Integer httpStatus;
    private Boolean status;
    private List<FieldError> errors;
}
