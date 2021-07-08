package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface UserMapper {

    List<UserVo> getList(); //유저 목록 불러오기

    int InsertUser(UserVo uvo); //유저 등록하기

    ArrayList<UserVo> findByUserId(String id); //유저 정보 불러오기

//    //유저 FK번호 알아내기
//    int findUserNo(String id);

    //권한 FK번호 알아내기
    int findRoleNo(String role);
}
