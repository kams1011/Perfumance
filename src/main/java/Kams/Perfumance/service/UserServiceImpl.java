package Kams.Perfumance.service;

import Kams.Perfumance.mapper.UserMapper;
import Kams.Perfumance.vo.UserVo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserVo> getAllUser() {

      return userMapper.getList();
    }

    @Override
    public int SignUp(UserVo userVo) {

       return userMapper.InsertUser(userVo);
    }
}
