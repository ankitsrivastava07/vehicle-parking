package carparking.B2B.dto;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotBlank(message = "Please enter valid first name")
    private String firstName;
    @NotBlank(message = "Please enter valid last name")
    private String lastName;
    @Email(message = "Please enter valid email")
    private String email;
    @NotBlank(message = "Please enter valid mobile number")
    private String mobile;
   // @NotBlank(message = "Please enter valid url name")
    private String urlName;
    @NotNull(message = "Please enter valid amount")
    private Double amount;
    @NotNull(message = "Please enter valid package id")
    private Long packageId;
}
