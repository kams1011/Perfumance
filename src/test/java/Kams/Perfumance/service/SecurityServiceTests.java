package Kams.Perfumance.service;


import Kams.Perfumance.vo.MemberVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityServiceTests {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    SecurityService securityService;



    //이미 사용중인 ID TEST
    @Test
    public void signUpTest(){
        String pwd = bCryptPasswordEncoder.encode("2");
        MemberVo memberVo = MemberVo.builder()
                .id("1")
                .pwd(pwd)
                .email("3")
                .nick("4")
                .build();
        securityService.SignUp(memberVo.getId(), memberVo.getPwd(), memberVo.getNick(), memberVo.getEmail());
    }






}
