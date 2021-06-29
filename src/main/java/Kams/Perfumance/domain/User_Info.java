package Kams.Perfumance.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
public class User_Info {

    private final String id;
    private final String pwd;
    private final String nick;
    private final Date regdt;  //가입일자
    private final Date deldt;  //탈퇴일자
    private final int dealnum;  //거래횟수

    @Builder
    public User_Info(String id, String pwd, String nick, Date regdt, Date deldt, int dealnum){
        this.id = id;
        this.pwd = pwd;
        this.nick = nick;
        this.regdt = null;
        this.deldt = null;
        this.dealnum = 0;
    }

}
