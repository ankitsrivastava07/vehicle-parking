package carparking.dto;
import lombok.Data;
import javax.validation.constraints.NotBlank;
@Data
public class LoginDto {
    @NotBlank(message = "Please enter valid email or mobile")
    private String email;
    @NotBlank(message = "Please enter valid password")
    private String password;
}
