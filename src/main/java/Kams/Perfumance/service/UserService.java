package Kams.Perfumance.service;

import Kams.Perfumance.mapper.UserMapper;
import Kams.Perfumance.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    public List<UserVo> getAllUser();

    public int SignUp(UserVo userVo);
}


