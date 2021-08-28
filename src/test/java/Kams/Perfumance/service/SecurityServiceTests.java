package Kams.Perfumance.service;


import Kams.Perfumance.mapper.MemberMapper;
import Kams.Perfumance.vo.MemberVo;
import Kams.Perfumance.vo.RoleVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityServiceTests {

    Date date = new Date();
    MemberMapper memberMapper;
    BCryptPasswordEncoder bCryptPasswordEncoder;


//    public SecurityServiceTests(MemberMapper memberMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.memberMapper = memberMapper;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

    SecurityService sService;
//    public SecurityServiceTests(SecurityService sService) {
//        this.sService = sService;
//    }


    @Test
    public void SignUpTest(){




        RoleVo roleVo = RoleVo.builder()
                        .role("USER")
                        .build();

    }

    @Test
    public void SignupTest2(){
        String id = "1";
//        String pwd = "pwd";
//        String nick = "nick";
//        String email = "email";

         System.out.println(memberMapper.findByUserId("1"));


//        String encodePassword = bCryptPasswordEncoder.encode(pwd);

//       sService.SignUp(id, pwd, nick, email);


    }

}
