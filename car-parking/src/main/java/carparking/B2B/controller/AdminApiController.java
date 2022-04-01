package carparking.B2B.controller;
import carparking.B2B.dao.entity.UserEntity;
import carparking.B2B.dao.repository.UserRepository;
import carparking.B2B.dto.UserDto;
import carparking.B2B.response.ResponseConstant;
import carparking.B2B.service.B2BService;
import carparking.dto.CreateUserDto;
import carparking.dto.LoginDto;
import carparking.security_config.authentication_provider.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RequestMapping("/api/v1/admin")
@RestController
public class AdminApiController {
    @Autowired B2BService b2BService;
    @Autowired UserRepository userRepository;
    @Autowired AuthenticationProvider authenticationProvider;

    @PostMapping("/createUser")
    public ResponseEntity<?> addAdmin(@RequestBody @Valid CreateUserDto createUserDto){
      ResponseConstant responseConstant = b2BService.addUser(createUserDto);
        return new ResponseEntity<>(responseConstant,HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<?> addUserByAdmin(@RequestBody @Valid UserDto userDto) throws ExecutionException, InterruptedException {
        ResponseConstant responseConstant = b2BService.saveUser(userDto);
        return new ResponseEntity<>(responseConstant,HttpStatus.valueOf(responseConstant.getHttpStatusCode()));
    }

    @PostMapping("/login")
    //@PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto){
        PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(loginDto.getEmail(),loginDto.getPassword());
        authenticationProvider.authenticate(token);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
