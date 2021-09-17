package Kams.Perfumance.service;

import Kams.Perfumance.vo.MemberVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public interface UserService {

    public List<MemberVo> getAllUser();

    public String userDisabled(String id);

    public ArrayList<MemberVo> getUserInfo(String id);

    public int checkTryCount(String id);

    public int resetTryCount(String id);

}


