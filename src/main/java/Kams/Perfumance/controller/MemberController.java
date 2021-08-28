package Kams.Perfumance.controller;


import Kams.Perfumance.service.SecurityService;
import Kams.Perfumance.vo.MemberVo;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    SecurityService sService;


    @ResponseBody
    @RequestMapping(value = "/signuptest", method = RequestMethod.POST)
    public void SignUpTest(@RequestParam("id") String id, @RequestParam("pwd") String pwd, @RequestParam("nick") String nick, @RequestParam("email") String email){

        sService.SignUp(id, pwd, nick, email);

    }


    @ResponseBody
    @RequestMapping(value ="/resttest", method = RequestMethod.GET)
    public String RestTest(){
        return "rest";
    }

}
