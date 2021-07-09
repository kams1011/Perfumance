package Kams.Perfumance.service;

import Kams.Perfumance.mapper.MemberMapper;
import Kams.Perfumance.vo.MemberPrincipalVo;
import Kams.Perfumance.vo.RoleVo;
import Kams.Perfumance.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class SecurityService implements UserDetailsService {

        @Autowired
        private MemberMapper memberMapper;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

    //DB에서 유저정보를 불러온다. Custom한 Userdetails 클래스를 리턴 해주면 된다.(실질적인 로그인코드)
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        ArrayList<MemberVo> userAuthes = memberMapper.findByUserId(id);

        if(userAuthes.size() == 0) {
            throw new UsernameNotFoundException("User "+id+" Not Found!");
        }

        return new MemberPrincipalVo(userAuthes);
    }

    //
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public String SignUp(MemberVo memberVo, RoleVo roleVo) throws Exception {
        memberVo.builder().pwd((bCryptPasswordEncoder.encode(memberVo.getPwd())));
        int flag = memberMapper.InsertUser(memberVo);
        System.out.println("flag num : "+flag);

        if (flag > 0) {
            int uno = memberVo.getUno();
            memberMapper.userRoleSave(uno, 2);

            return "success";
        }
        return "fail";
    }

}

