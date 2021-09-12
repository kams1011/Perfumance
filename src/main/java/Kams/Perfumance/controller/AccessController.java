package Kams.Perfumance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/access")
public class AccessController {


    @GetMapping("/login")
    public String login(){
        return "access/login";
    }

    @GetMapping("/register")
    public String register(){
        return "access/register";
    }

//    Post매핑으로 변경


}
