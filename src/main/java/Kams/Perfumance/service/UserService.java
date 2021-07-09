package Kams.Perfumance.service;

import Kams.Perfumance.vo.MemberVo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    public List<MemberVo> getAllUser();

    public int SignUp(MemberVo memberVo);
}


