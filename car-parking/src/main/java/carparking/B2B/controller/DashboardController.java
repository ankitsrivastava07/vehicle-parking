package carparking.B2B.controller;
import carparking.B2B.dao.repository.UserRepository;
import carparking.B2B.service.B2BService;
import carparking.constant.ParkingConstant;
import carparking.dto.DashboardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired UserRepository userRepository;
    @Autowired B2BService b2BService;

    @GetMapping("/getAllRecords")
    public ResponseEntity<?> dashboard(@RequestParam("userEncId")String userEncId){
       // DashboardDto dashboardDto =b2BService.dashBoardData(ParkingConstant.ADMIN);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
}
