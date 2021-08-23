package Kams.Perfumance.service;

import Kams.Perfumance.mapper.MemberMapper;
import Kams.Perfumance.vo.MemberVo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    MemberMapper memberMapper;
    Date date = new Date();

    public UserServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberVo> getAllUser() {

        return memberMapper.getList();
    }


}
