package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

    List<UserVo> getList();

    void Insert(UserVo uvo);
}
