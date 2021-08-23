package Kams.Perfumance.service;


import Kams.Perfumance.vo.MemberVo;
import Kams.Perfumance.vo.RoleVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityServiceTests {

    Date date = new Date();

    SecurityService securityService;


    @Test
    public void SignUpTest(){
        MemberVo memberVo = MemberVo.builder()
                .enable('Y')
                .id("kams")
                .pwd("1234")
                .nick("kams")
                .email("kams@naver.com")
                .img("baseImg")
                .regdt(date)
                .deldt(null)
                .dealnum(0)
                .build();

        RoleVo roleVo = RoleVo.builder()
                        .role("USER")
                        .build();

    }


}
