package Kams.Perfumance.vo;


import org.junit.jupiter.api.Test;

import java.util.Date;

public class User_VoTests {


    @Test
    public void User_InfoTest(){
        Date date = new Date();
        MemberVo user = MemberVo.builder()
                .id("kams")
                .pwd("1234")
                .nick("kams")
                .deldt(null)
                .regdt(date)
                .build();

        System.out.println(user.getId());
        System.out.println(user.getPwd());
        System.out.println(user.getNick());
        System.out.println(user.getRegdt());
        System.out.println(user.getDeldt());
    }

}
