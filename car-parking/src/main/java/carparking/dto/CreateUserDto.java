package carparking.dto;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CreateUserDto {

    @NotBlank(message = "Please enter valid first name")
    private String firstName;
    @NotBlank(message ="Please enter valid lastname")
    private String lastName;
    @NotBlank(message = "Please enter email ")
    @Email(message = "Please enter valid email ")
    private String email;
    @NotBlank(message = "Please enter valid password")
    private String password;
    @NotBlank(message = "Please enter valid mobile")
    private String mobile;
    @NotBlank(message = "Please enter valid package Id")
    private Long packageId;
}
