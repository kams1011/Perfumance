package Kams.Perfumance.service;


import Kams.Perfumance.vo.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

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
        String pwd = bCryptPasswordEncoder.encode("123");
        MemberVO memberVo = MemberVO.builder()
                .id("kk")
                .pwd(pwd)
                .email("3")
                .nick("4")
                .build();
        securityService.SignUp(memberVo.getId(), memberVo.getPwd(), memberVo.getNick(), memberVo.getEmail());
    }

    @Test
    public void commitTEst(){
        System.out.println("커밋테스트입니다.");
    }

    @Test
    public void loadByUsernameTest(){
        System.out.println(securityService.loadUserByUsername("1"));
    }



}
