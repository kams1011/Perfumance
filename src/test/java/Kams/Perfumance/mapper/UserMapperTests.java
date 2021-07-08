package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTests {

    private UserMapper uMapper;
    Date date = new Date();


    @Test
    public void getListTest(){
       System.out.println(uMapper.getList());
    }


    @Test
    public void insertTest(){
        UserVo uvo = UserVo.builder()
                .id("7")
                .pwd("3")
                .nick("3")
                .email("3")
                .img("3")
                .regdt(date)
                .deldt(date)
                .dealnum(0)
                .build();

        try{
           uMapper.InsertUser(uvo);
        }catch(Exception e){
            System.out.println("인서트 에러입니다.");
        }
    }


}
