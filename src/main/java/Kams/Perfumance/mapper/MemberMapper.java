package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;
import java.util.List;


@Mapper
public interface MemberMapper {

    //유저 목록 불러오기
    List<MemberVO> getList();

    //유저 등록하기
    int InsertUser(MemberVO uvo);

    //유저 정보 불러오기
    ArrayList<MemberVO> findByUserId(String id);

    //유저 권한 저장
    int userRoleSave(@Param("uno") int uno, @Param("rno") int rno);

    //유저 PK번호 알아내기
    Integer findUserNo(String id);

    //권한 FK번호 알아내기
    int findRoleNo(String authority);

    //계정 비활성화 하기
    String updateEnabled(String id);

    //로그인 실패 회수 카운트하기
    int addTryCount(String id);

    //로그인 성공시 로그인 실패 회수 초기화하기
    int resetTryCount(String id);

    String getAuth(String id);

}
