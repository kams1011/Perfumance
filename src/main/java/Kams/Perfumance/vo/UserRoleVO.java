package Kams.Perfumance.vo;


import lombok.Builder;
import lombok.Getter;

@Getter
public class UserRoleVO {

    private int uno;
    private int rno;


    @Builder
    public UserRoleVO(int uno, int rno){
        this.uno = uno;
        this.rno = rno;
    }

}
