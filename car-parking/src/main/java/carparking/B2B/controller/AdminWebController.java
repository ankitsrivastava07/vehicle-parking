package carparking.B2B.controller;
import carparking.B2B.service.B2BService;
import carparking.dto.DashboardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping({"/admin","/admin/"})
@RestController
public class AdminWebController {
    @Autowired
    private B2BService b2BService;

    @GetMapping
    public ModelAndView index(){
        DashboardDto dto = b2BService.dashBoardData();
        ModelAndView mv = new ModelAndView("easyparking/easyparking-dashboard");
        mv.addObject("dashboardDto",dto);
        return mv;
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
