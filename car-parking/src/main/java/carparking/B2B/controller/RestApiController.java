package carparking.B2B.controller;
import carparking.B2B.dao.entity.UserEntity;
import carparking.B2B.dao.repository.UserRepository;
import carparking.B2B.dto.UserDto;
import carparking.B2B.response.ResponseConstant;
import carparking.B2B.service.B2BService;
import carparking.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RequestMapping("/api/v1/user")
@RestController
public class RestApiController {
@Autowired
    B2BService b2BService;
@Autowired
    UserRepository userRepository;
    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserDto userDto) throws ExecutionException, InterruptedException {
        ResponseConstant responseConstant = b2BService.saveUser(userDto);
        return new ResponseEntity<>(responseConstant,HttpStatus.valueOf(responseConstant.getHttpStatusCode()));
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginDto loginDto){
       UserEntity userEntity= userRepository.findByEmailOrMobileAndPassword(loginDto.getEmail(),loginDto.getPassword());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
