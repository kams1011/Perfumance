package Kams.Perfumance.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class User {

    private final String id;
    private final String pwd;
    private final String nick;
    private final Date regdt;  //가입일자
    private final Date deldt;  //탈퇴일자
    private final int tradenum;  //거래횟수
}
