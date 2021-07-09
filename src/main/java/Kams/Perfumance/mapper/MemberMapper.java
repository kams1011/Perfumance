package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface MemberMapper {

    List<MemberVo> getList(); //유저 목록 불러오기

    int InsertUser(MemberVo uvo); //유저 등록하기

    ArrayList<MemberVo> findByUserId(String id); //유저 정보 불러오기

    //유저 권한 저장
    int userRoleSave(int userNo, int roleNo);

    //유저 FK번호 알아내기
    int findUserNo(String id);

    //권한 FK번호 알아내기
    int findRoleNo(String authority);
}
