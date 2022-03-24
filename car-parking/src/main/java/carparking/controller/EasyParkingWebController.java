package carparking.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping({"","/"})
@RestController
public class EasyParkingWebController {

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("easyparking/index");
    }

    @GetMapping("/sign-in")
    public ModelAndView login(){
        return new ModelAndView("easyparking/easyparking-login");
    }
}
