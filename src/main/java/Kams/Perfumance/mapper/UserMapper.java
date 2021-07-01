package Kams.Perfumance.mapper;


import Kams.Perfumance.domain.User_Info;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<User_Info> getList();

}
