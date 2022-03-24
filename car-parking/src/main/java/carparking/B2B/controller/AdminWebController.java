package carparking.B2B.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping({"/admin","/admin/"})
@RestController
public class AdminWebController {

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("easyparking/easyparking-dashboard");
    }
    @GetMapping("/sign-in")
    public ModelAndView login(){
        return new ModelAndView("easyparking/sign-in");
    }

    @GetMapping("/sign-up")
    public ModelAndView signUp(){
        return new ModelAndView("easyparking/sign-up");
    }

    @GetMapping("/create-user")
    public ModelAndView createUser(){
        return new ModelAndView("easyparking/create-user");
    }
}
