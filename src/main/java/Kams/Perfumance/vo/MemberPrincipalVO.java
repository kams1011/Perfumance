package Kams.Perfumance.vo;

import Kams.Perfumance.mapper.MemberMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class MemberPrincipalVO implements UserDetails {

    private ArrayList<MemberVO> memberVO;
    private ArrayList<GrantedAuthority> authorities;

    public MemberPrincipalVO(ArrayList<MemberVO> memberVO){
        this.memberVO = memberVO;
    }

    @Override // 계정이 갖고있는 권한 목록을 리턴한다.
    public Collection<? extends GrantedAuthority> getAuthorities(){
        ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(authorities);
        return authList;
    }

    @Override // 유저 아이디
    public String getUsername(){
        return memberVO.get(0).getId();
    }
    
    
    @Override // 유저 비밀번호
    public String getPassword(){
        return memberVO.get(0).getPwd();
    }


    @Override // 계정 활성화 여부
    public boolean isEnabled(){

      return false;
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
