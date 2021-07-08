package Kams.Perfumance.vo;


import lombok.*;

import java.util.Date;

@Getter
public class UserVo {
    
    private String uno; // 인조키
    private char enable; // 계정 활성화 여부
    private String id;
    private String pwd;
    private String role; // 권한
    private String nick;
    private String email;
    private String img;  //프로필사진
    private Date regdt;  //가입일자
    private Date deldt;  //탈퇴일자
    private int dealnum;  //거래횟수
    


    @Builder
    public UserVo(String id, String pwd, String nick, String email, String img,  String role,
                  char enable, Date regdt, Date deldt, int dealnum){
        this.uno = uno;
        this.enable = enable;
        this.id = id;
        this.pwd = pwd;
        this.role = role;
        this.nick = nick;
        this.email = email;
        this.img = img;
        this.regdt = regdt;
        this.deldt = deldt;
        this.dealnum = dealnum;
    }
    //Builder에서 생성자가 @Builder.Default보다 우선한다.





}
