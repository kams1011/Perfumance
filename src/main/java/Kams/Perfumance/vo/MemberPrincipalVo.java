package Kams.Perfumance.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


//@SuppressWarnings("serial") // java.io.Serializable 인터페이스 구현할때 serialVersionUID 정의 안하면 생기는 오류 막아줌
public class MemberPrincipalVo implements UserDetails {

    private ArrayList<MemberVo> memberVo;
    private ArrayList<GrantedAuthority> authorities;

    public MemberPrincipalVo(ArrayList<MemberVo> userAuthes){
        this.memberVo = userAuthes;
    }

    @Override // 계정이 갖고있는 권한 목록을 리턴한다.
    public Collection<? extends GrantedAuthority> getAuthorities(){
        ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(authorities);

        return authList;
    }

    @Override // 유저 아이디
    public String getUsername(){

        return memberVo.get(0).getId();
    }
    
    
    @Override // 유저 비밀번호
    public String getPassword(){

        return memberVo.get(0).getPwd();
    }


    @Override // 계정 활성화 여부
    public boolean isEnabled(){

      return true;

    }



    @Override
    public boolean isAccountNonExpired() {// 유저 아이디가 만료 되었는지

        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 유저 아이디가 Lock 걸렸는지

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비밀번호가 만료 되었는지

        return true;
    }



}
