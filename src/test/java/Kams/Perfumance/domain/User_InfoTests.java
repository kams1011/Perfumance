package Kams.Perfumance.domain;


import org.apache.catalina.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class User_InfoTests {


    @Test
    public void User_InfoTest(){
        Date date = new Date();
        User_Info user = User_Info.builder()
                .id("kams")
                .pwd("1234")
                .nick("kams")
                .deldt(null)
                .regdt(date)
                .dealnum(0)
                .build();

        System.out.println(user.getId());
        System.out.println(user.getPwd());
        System.out.println(user.getNick());
        System.out.println(user.getRegdt());
        System.out.println(user.getDeldt());
        System.out.println(user.getDealnum());
    }

}
