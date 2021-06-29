package Kams.Perfumance.controller;

import Kams.Perfumance.domain.User_Info;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/user")
    public String user(@ModelAttribute User_Info user, Model model){

        return "user";
    }





}
