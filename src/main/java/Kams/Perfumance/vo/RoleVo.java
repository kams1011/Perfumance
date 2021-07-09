package Kams.Perfumance.vo;


import lombok.Builder;
import lombok.Getter;

@Getter
public class RoleVo {

    private int rno;
    private String role;


    @Builder
    public RoleVo(int rno, String role){
        this.rno = rno;
        this.role = role;
    }

}
