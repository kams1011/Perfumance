package Kams.Perfumance.controller;


import Kams.Perfumance.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomeController {


    //Restcontroller로 하면 String만 반환되는 이유??

    private final UserServiceImpl userService;

    @Autowired
    public HomeController(UserServiceImpl userService){
        this.userService=userService;
    }

//    @GetMapping("user")
//    public String user(@ModelAttribute UserVo user, Model model){
//        return "/home/user";
//    }
//
    @GetMapping("select")
    public void selectTest(){
        System.out.println(userService.getAllUser());
    }
//
//
//    @GetMapping("insert")
//    public void insertTest(){
//        Date date = new Date();
//        UserVo uvo = UserVo.builder()
//                .id("4")
//                .pwd("4")
//                .nick("$")
//                .email("4")
//                .img("4")
//                .regdt(date)
//                .deldt(date)
//                .dealnum(0)
//                .build();
//        userService.Register(uvo);
//    }

    @GetMapping("/user")
    public String User(Model model){
        model.addAttribute("list",userService.getAllUser());

        return "home/user";
    }

    @GetMapping("s")
    public String s(){
        return "s";
    }

}
