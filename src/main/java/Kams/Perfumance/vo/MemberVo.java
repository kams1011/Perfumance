package Kams.Perfumance.vo;


import lombok.*;

import java.util.Date;

@Getter
public class MemberVo {
    
    private int uno; // 인조키
    private String enable; // 계정 활성화 여부
    private String id;
    private String pwd;
    private String nick;
    private String email;
    private String img;  //프로필사진
    private Date regDt;  //가입일자
    private Date delDt;  //탈퇴일자
    private int dealnum;  //거래횟수
    private int tryNum;
    


    @Builder
    public MemberVo(int uno, String enable, String id, String pwd, String nick, String email, String img,
                     Date regDt, Date delDt, int dealnum, int tryNum){
        this.uno = uno;
        this.enable = enable;
        this.id = id;
        this.pwd = pwd;
        this.nick = nick;
        this.email = email;
        this.img = img;
        this.regDt = regDt;
        this.delDt = delDt;
        this.dealnum = dealnum;
        this.tryNum = tryNum;
    }
    //Builder에서 생성자가 @Builder.Default보다 우선한다.





}
