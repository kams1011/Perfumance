package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.MemberVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
public class MemberMapperTests {

    private MemberMapper uMapper;
    Date date = new Date();


    @Test
    public void getListTest(){
       System.out.println(uMapper.getList());
    }


    @Test
    public void insertTest(){
        MemberVo uvo = MemberVo.builder()
                .id("7")
                .pwd("3")
                .nick("3")
                .email("3")
                .img("3")
                .regdt(date)
                .deldt(date)
                .build();

        try{
           uMapper.InsertUser(uvo);
        }catch(Exception e){
            System.out.println("인서트 에러입니다.");
        }
    }


}
