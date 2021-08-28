package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.MemberVo;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;


    Date date = new Date();


    @Test
    public void getListTest(){
       System.out.println(memberMapper.getList());
    }


    @Test
    public void insertTest(){
        MemberVo uvo = MemberVo.builder()
                .id("122412")
                .pwd("3")
                .nick("3")
                .email("3")
                .img("3")
                .regdt(date)
                .deldt(date)
                .build();

        try{memberMapper.InsertUser(uvo);
           System.out.println("인서트 성공");
        }catch(Exception e){
            System.out.println("인서트 에러입니다.");
            e.printStackTrace();
        }
    }


}
