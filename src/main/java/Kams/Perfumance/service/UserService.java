package Kams.Perfumance.service;

import Kams.Perfumance.vo.MemberVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public interface UserService {

    public List<MemberVO> getAllUser();

    public String userDisabled(String id);

    public ArrayList<MemberVO> getUserInfo(String id);

    public int checkTryCount(String id);

    public int resetTryCount(String id);

}


