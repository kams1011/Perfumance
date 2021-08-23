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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;

@Service
public class SecurityService implements UserDetailsService {

    MemberMapper memberMapper;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    Date date = new Date();

    public SecurityService(MemberMapper memberMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberMapper = memberMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    //DB에서 유저정보를 불러온다. Custom한 Userdetails 클래스를 리턴 해주면 된다.(실질적인 로그인코드)
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        ArrayList<MemberVo> userAuthes = memberMapper.findByUserId(id);

        if(userAuthes.size() == 0) {
            throw new UsernameNotFoundException("User "+id+" Not Found!");
        }

        return new MemberPrincipalVo(userAuthes);
    }

//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
//    public String SignUp(MemberVo memberVo, RoleVo roleVo){
//        memberVo.builder().pwd((bCryptPasswordEncoder.encode(memberVo.getPwd())));
//        memberMapper.InsertUser(memberVo);
//
//        if (memberMapper.InsertUser(memberVo) > 0) {
//            int uno = memberVo.getUno();
//            memberMapper.userRoleSave(uno, 2);
//
//            return "success";
//        }
//        return "fail";
//    }

    public void SignUp(MemberVo memberVo) {
        try {

            ArrayList<MemberVo> m = memberMapper.findByUserId(memberVo.getId());
            // 이미 유저가 존재할 때
            if (m != null) {
                System.out.println("이미 사용중인 ID입니다.");
            }else{
                // 비밀번호 암호화
                String encodePassword = bCryptPasswordEncoder.encode(memberVo.getPwd());
                MemberVo member = MemberVo.builder()
                        .enable('Y')
                        .id(memberVo.getId())
                        .nick(memberVo.getNick())
                        .email(memberVo.getEmail())
                        .img("baseImg")
                        .regdt(date)
                        .deldt(null)
                        .dealnum(0)
                        .pwd(encodePassword).build();

                memberMapper.InsertUser(member);
                System.out.println("회원가입 완료.");
            }
        }catch(Exception e) {
            //Rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println("회원가입 에러 발생.");
        }
    }

}

