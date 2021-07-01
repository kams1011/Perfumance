package Kams.Perfumance.service;


import Kams.Perfumance.domain.User_Info;
import Kams.Perfumance.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService{
//    private UserRepository userRepository;

//    @Transactional
//    public Long joinUser(User_Info user_info){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        user_info.builder()
//                .pwd(passwordEncoder.encode(user_info.getPwd()))
//                .build();
//        return UserRepository.save(user_info.toEntity()).getId();
//    }

    @Autowired
    private UserMapper userMapper;

    public List<User_Info> getList(){
        return userMapper.getList();
    }
}
