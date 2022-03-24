package carparking.B2B.response;
import lombok.Data;

@Data
public class ResponseConstant {
    private String message;
    private Integer httpStatusCode;
    private Object data;
    private Boolean status;
}
