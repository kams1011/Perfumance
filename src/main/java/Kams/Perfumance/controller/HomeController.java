package Kams.Perfumance.controller;


import Kams.Perfumance.service.SecurityService;
import Kams.Perfumance.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/home")
public class HomeController {


    private final UserServiceImpl userService;
    private final SecurityService sService;


    public HomeController(UserServiceImpl userService, SecurityService sService){
        this.userService=userService;
        this.sService=sService;
    }

    @GetMapping("main")
    public String main(){
        return "home/main";
    }


}
