package Kams.Perfumance.service;

import Kams.Perfumance.domain.User_Info;
import Kams.Perfumance.mapper.UserMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User_Info> getUserList();

    void UserInsert();

}
