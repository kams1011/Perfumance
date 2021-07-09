package Kams.Perfumance.service;

import Kams.Perfumance.mapper.MemberMapper;
import Kams.Perfumance.vo.MemberVo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<MemberVo> getAllUser() {

      return memberMapper.getList();
    }

    @Override
    public int SignUp(MemberVo memberVo) {

       return memberMapper.InsertUser(memberVo);
    }
}
