package Kams.Perfumance.controller;


import Kams.Perfumance.service.SecurityService;
import Kams.Perfumance.service.UserServiceImpl;
import Kams.Perfumance.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {
    //Restcontroller로 하면 String만 반환되는 이유??

    private final UserServiceImpl userService;
    private final SecurityService sService;


    public HomeController(UserServiceImpl userService, SecurityService sService){
        this.userService=userService;
        this.sService=sService;
    }


    @GetMapping("select")
    public String selectTest(){
        String id="dada4202";
        String pwd="1234";
        String nick="ingda";
        String email="dada4202@naver.com";
        sService.SignUp(id,pwd,nick,email);
        return "home/select";

    }

    @GetMapping("main")
    public String main(){
        return "home/main";
    }


}
