package carparking.B2C.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/b2c")
public class RestApiController {

    @PostMapping("/addUser")
    public ResponseEntity<?> getAllRecord(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
