package Kams.Perfumance.domain;


import lombok.*;

import java.util.Date;

@Getter
public class User_Info {

    private String id;
    private String pwd;
    private String nick;
    private String email;
    private String img;  //프로필사진
    private Date deldt;  //탈퇴일자
    private Date regdt;  //가입일자
    private int dealnum;  //거래횟수


    @Builder
    public User_Info(String id, String pwd, String nick, String email, String img, Date regdt,
                     Date deldt, int dealnum){
        this.id = id;
        this.pwd = pwd;
        this.nick = nick;
        this.email = email;
        this.img = img;
        this.regdt = regdt;
        this.deldt = deldt;
        this.dealnum = dealnum;
    }

    //Builder에서 생성자가 @Builder.Default보다 우선한다.



}
