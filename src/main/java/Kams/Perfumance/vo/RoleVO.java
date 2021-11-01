package Kams.Perfumance.vo;


import lombok.Builder;
import lombok.Getter;

@Getter
public class RoleVO {

    private int rno;
    private String role;


    @Builder
    public RoleVO(int rno, String role){
        this.rno = rno;
        this.role = role;
    }

}
