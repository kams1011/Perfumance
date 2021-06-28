package Kams.Perfumance.domain;


import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.DateUtil.now;


public class UserTests {



    @Test
    public void  UserDomain_Test(){

         String id="test";
         String pwd="1234";
         String nick="kams";
         Date regdt = now();
         Date deldt = now();
         int tradenum = 11;

         User user = new User(id, pwd, nick, regdt, deldt, tradenum);


         assertThat(user.getId()).isEqualTo(id);
         assertThat(user.getPwd()).isEqualTo(pwd);
         assertThat(user.getDeldt()).isEqualTo(deldt);
         assertThat(user.getRegdt()).isEqualTo(regdt);
         assertThat(user.getTradenum()).isEqualTo(tradenum);
    }

}
