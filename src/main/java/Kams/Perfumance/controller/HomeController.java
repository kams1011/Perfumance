package Kams.Perfumance.controller;


import Kams.Perfumance.domain.User_Info;
import Kams.Perfumance.mapper.UserMapper;
import Kams.Perfumance.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    UserService uService;

    @GetMapping("user")
    public String user(@ModelAttribute User_Info user, Model model){
        return "/home/user";
    }

    @GetMapping("select")
    public void selectTest(){
        uService.getUserList();
    }



}
