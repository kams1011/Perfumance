package Kams.Perfumance.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


//@SuppressWarnings("serial") // java.io.Serializable 인터페이스 구현할때 serialVersionUID 정의 안하면 생기는 오류 막아줌
public class MemberPrincipalVo implements UserDetails {

    private ArrayList<UserVo> userVo;

    public MemberPrincipalVo(ArrayList<UserVo> userAuthes){
        this.userVo = userAuthes;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(){

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(int i=0; i<userVo.size(); i++){
            authorities.add(new SimpleGrantedAuthority(userVo.get(i).getRole()));
        }
        return authorities;
    }

    @Override // 유저 아이디
    public String getUsername(){

        return userVo.get(0).getId();
    }
    
    
    @Override // 유저 비밀번호
    public String getPassword(){

        return userVo.get(0).getPwd();
    }


    @Override // 계정 활성화 여부
    public boolean isEnabled(){

        if(userVo.get(0).getEnable()=='Y'){
            return true;
        }else{
            return false;
        }

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
