package Kams.Perfumance.controller;


import Kams.Perfumance.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public void insertTest(Model model){

    }

    @GetMapping("home/user")
    public String Usertest(Model model){



        return "home/user";
    }

    @GetMapping("test")
    public String User(Model model){



        return "board/test";
    }


}
