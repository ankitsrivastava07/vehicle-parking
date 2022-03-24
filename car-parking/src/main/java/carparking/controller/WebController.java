package carparking.controller;
import carparking.dao.CarParkingDaoService;
import carparking.dao.entity.ParkingEntity;
import carparking.dao.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RequestMapping("/uu")
@RestController
public class WebController {
    @Autowired
    ParkingRepository parkingRepository;
   @Autowired CarParkingDaoService carParkingDaoService;

   @GetMapping("/")
    public ResponseEntity<?> index(@RequestParam int pageNo, @RequestParam int pageSize){
     List<ParkingEntity> parkingEntity = parkingRepository.findByName("Smart Parking");
     ParkingEntity p1= new ParkingEntity();
     p1.setArea("A");
     p1.setName("Smart Parking");
         p1 = parkingRepository.insert(p1);

       PageRequest pageRequest= PageRequest.of(pageNo,pageSize, Sort.Direction.DESC,"area");
       ModelAndView mv =new ModelAndView("index");
       mv.setViewName("index");
       return new ResponseEntity<>("Saved", HttpStatus.ACCEPTED);
    }
}
