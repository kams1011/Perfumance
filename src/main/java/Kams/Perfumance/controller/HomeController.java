package Kams.Perfumance.controller;


import Kams.Perfumance.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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

    }

//    @GetMapping("/user")
//    public String User(Model model){
//
//
//        model.addAttribute("list",  userService.getAllUser().get(2).getId());
//
//        return "home/user";
//    }


}
