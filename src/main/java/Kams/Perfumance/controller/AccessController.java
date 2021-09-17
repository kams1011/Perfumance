package Kams.Perfumance.controller;

import Kams.Perfumance.service.SecurityService;
import Kams.Perfumance.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/access")
public class AccessController {

    @Autowired
    SecurityService securityService;


    @GetMapping("/login")
    public String login(){
        return "access/login";
    }

    @GetMapping("/denied")
    public String denied(){
        return "access/accessdenied";
    }

    @GetMapping("/register")
    public String register(String id){
        return "access/register";
    }

    @PostMapping("/register")
    public String register(String id, String pwd, String email, String nick){
        MemberVo memberVo = MemberVo.builder()
                .id(id)
                .pwd(pwd)
                .nick(nick)
                .email(email)
                .build();
    try{
        securityService.SignUp(memberVo.getId(),memberVo.getPwd(), memberVo.getNick(), memberVo.getEmail());
    }catch(Exception e){
       e.printStackTrace();
    }
        return "home/main";
    }

//    Post매핑으로 변경


}
