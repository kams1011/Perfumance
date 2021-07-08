package Kams.Perfumance.controller;


import Kams.Perfumance.service.UserServiceImpl;
import Kams.Perfumance.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;


@Controller
public class HomeController {
    //Restcontroller로 하면 String만 반환되는 이유??

    private final UserServiceImpl userService;

    @Autowired
    public HomeController(UserServiceImpl userService){
        this.userService=userService;
    }

    @GetMapping("select")
    public void selectTest(){
        System.out.println(userService.getAllUser());
    }


    @GetMapping("insert")
    public void insertTest(){
        Date date = new Date();
        UserVo uvo = UserVo.builder()
                .id("4")
                .pwd("4")
                .nick("$")
                .email("4")
                .img("4")
                .regdt(date)
                .deldt(date)
                .dealnum(0)
                .build();
        userService.SignUp(uvo);
    }

    @GetMapping("/user")
    public String User(Model model){


        model.addAttribute("list",  userService.getAllUser().get(2).getId());

        return "home/user";
    }


}
