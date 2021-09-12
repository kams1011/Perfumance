package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface MemberMapper {

    List<MemberVo> getList(); //유저 목록 불러오기

    int InsertUser(MemberVo uvo); //유저 등록하기

    ArrayList<MemberVo> findByUserId(String id); //유저 정보 불러오기

    //유저 권한 저장
    int userRoleSave(@Param("uno") int uno, @Param("rno") int rno);

    //유저 FK번호 알아내기
    Integer findUserNo(String id);

    //권한 FK번호 알아내기
    int findRoleNo(String authority);
}
