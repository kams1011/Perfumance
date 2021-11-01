package Kams.Perfumance.service;

import Kams.Perfumance.mapper.MemberMapper;
import Kams.Perfumance.vo.MemberVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    MemberMapper memberMapper;

    public UserServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberVO> getAllUser() {
        return memberMapper.getList();
    }

    @Override
    public String userDisabled(String id){ return memberMapper.updateEnabled(id); }

    @Override
    public ArrayList<MemberVO> getUserInfo(String id){
        return memberMapper.findByUserId(id);
    }

    @Override
    public int checkTryCount(String id){
        return memberMapper.addTryCount(id);
    }

    @Override
    public int resetTryCount(String id) { return memberMapper.resetTryCount(id); }

}




