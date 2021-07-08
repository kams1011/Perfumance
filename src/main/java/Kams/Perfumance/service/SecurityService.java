package Kams.Perfumance.service;

import Kams.Perfumance.mapper.UserMapper;
import Kams.Perfumance.vo.MemberPrincipalVo;
import Kams.Perfumance.vo.UserVo;
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
        private UserMapper userMapper;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

    //DB에서 유저정보를 불러온다. Custom한 Userdetails 클래스를 리턴 해주면 된다.(실질적인 로그인코드)
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        System.out.println("id : "+id);
        ArrayList<UserVo> userAuthes = userMapper.findByUserId(id);
        System.out.println("userAuthes size : "+userAuthes.size());

        if(userAuthes.size() == 0) {
            throw new UsernameNotFoundException("User "+id+" Not Found!");
        }

        return new MemberPrincipalVo(userAuthes);
    }

    //
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public String SignUp(UserVo userVo throws Exception {
        userVo.builder().pwd((bCryptPasswordEncoder.encode(userVo.getPwd())));
        int flag = userMapper.InsertUser(userVo);
        System.out.println("flag num : "+flag);

        if (flag > 0) {
            userVo.builder().role("USER");
            int roleNo = userMapper.findRoleNo(userVo.getRole());
            System.out.println("roleNo : "+roleNo);
            String id = userVo.getId();
            userMapper.userRoleSave(id, roleNo);

            return "success";
        }
        return "fail";
    }

}

