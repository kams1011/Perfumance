package Kams.Perfumance.service;


import Kams.Perfumance.domain.User_Info;
import Kams.Perfumance.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


//    @Autowired  //Autowired 교체요망!
    private UserMapper userMapper;

    @Override
    public List<User_Info> getUserList(){
        return userMapper.getList();
    }

    @Override
    public void UserInsert() {
    }
}
