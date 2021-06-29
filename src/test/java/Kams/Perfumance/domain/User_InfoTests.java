package Kams.Perfumance.domain;


import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.DateUtil.now;


public class User_InfoTests {



    @Test
    public void  UserDomain_Test(){

         String id="test";
         String pwd="1234";
         String nick="kams";
         Date regdt = now();
         Date deldt = now();
         int tradenum = 11;

         User_Info userInfo = new User_Info(id, pwd, nick, regdt, deldt, tradenum);


         assertThat(userInfo.getId()).isEqualTo(id);
         assertThat(userInfo.getPwd()).isEqualTo(pwd);
         assertThat(userInfo.getDeldt()).isEqualTo(deldt);
         assertThat(userInfo.getRegdt()).isEqualTo(regdt);
         assertThat(userInfo.getDealnum()).isEqualTo(tradenum);
    }

}
