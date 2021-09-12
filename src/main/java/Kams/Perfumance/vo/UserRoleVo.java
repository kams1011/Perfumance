package Kams.Perfumance.vo;


import lombok.Builder;
import lombok.Getter;

@Getter
public class UserRoleVo {

    private int uno;
    private int rno;


    @Builder
    public UserRoleVo(int uno, int rno){
        this.uno = uno;
        this.rno = rno;
    }

}
