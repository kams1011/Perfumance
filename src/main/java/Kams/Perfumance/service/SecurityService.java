package Kams.Perfumance.service;

import Kams.Perfumance.mapper.MemberMapper;
import Kams.Perfumance.vo.MemberPrincipalVO;
import Kams.Perfumance.vo.RoleVO;
import Kams.Perfumance.vo.MemberVO;
import Kams.Perfumance.vo.UserRoleVO;
import org.apache.ibatis.annotations.Param;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
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
    public MemberPrincipalVO loadUserByUsername(String username) throws UsernameNotFoundException {
        ArrayList<MemberVO> memberVos = memberMapper.findByUserId(username);
        MemberPrincipalVO memberPrincipalVo = new MemberPrincipalVO(memberVos);
            return memberPrincipalVo;
    }

    public void SignUp(@Param("id") String id, @Param("pwd") String pwd, @Param("nick") String nick, @Param("email") String email) {
        try {
            Integer m = memberMapper.findUserNo(id);
            // 이미 유저가 존재할 때
            if (m != null) {
                System.out.println(m);
                System.out.println("이미 사용중인 ID입니다.");
            }else{
                // 비밀번호 암호화
                String encodePassword = bCryptPasswordEncoder.encode(pwd);
                MemberVO member = MemberVO.builder()
                        .enabled("true")
                        .id(id)
                        .pwd(encodePassword)
                        .nick(nick)
                        .email(email)
                        .img("baseImg")
                        .regDt(date)
                        .delDt(null)
                        .dealNum(0)
                        .tryCount(0).build();
                //DB에 회원정보 등록
                memberMapper.InsertUser(member);
                //ROLE 등록을 위한 객체 생성
                UserRoleVO userRoleVo = UserRoleVO.builder()
                        .uno(memberMapper.findUserNo(id))
                        .rno(2)
                        .build();
                //DB에 ROLE 등록
                memberMapper.userRoleSave(userRoleVo.getUno(), userRoleVo.getRno());
                ///이거 트랜잭션 처리 제대로 되나 확인. 아이디 회원가입은 되는데 role에 입력안되는거같기도함.
                System.out.println("회원가입 완료.");
            }
        }catch(Exception e) {
            //Rollback
            e.printStackTrace();
            System.out.println("회원가입 에러 발생.");
        }
    }




}

