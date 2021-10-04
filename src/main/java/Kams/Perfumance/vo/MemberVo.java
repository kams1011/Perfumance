package Kams.Perfumance.vo;


import lombok.*;

import java.util.Date;

@Getter
public class MemberVo {
    
    private int uno; // 인조키
    private String enabled; // 계정 활성화 여부
    private String id;
    private String pwd;
    private String nick;
    private String email;
    private String img;  //프로필사진
    private Date regDt;  //가입일자
    private Date delDt;  //탈퇴일자
    private int dealNum;  //거래횟수
    private int tryCount; //로그인시도횟수
    


    @Builder
    public MemberVo(int uno, String enabled, String id, String pwd, String nick, String email, String img,
                     Date regDt, Date delDt, int dealNum, int tryCount){
        this.uno = uno;
        this.enabled = enabled;
        this.id = id;
        this.pwd = pwd;
        this.nick = nick;
        this.email = email;
        this.img = img;
        this.regDt = regDt;
        this.delDt = delDt;
        this.dealNum = dealNum;
        this.tryCount = tryCount;
    }
    //Builder에서 생성자가 @Builder.Default보다 우선한다.





}
