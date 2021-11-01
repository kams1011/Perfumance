package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void mapperTest(){
       ArrayList<MemberVO> test = memberMapper.findByUserId("kams1");
       System.out.println(test.get(0).getTryCount());
    }
    @Test
    public void addTryContTest(){
        int result = memberMapper.addTryCount("kams1");
        System.out.println(result);
    }
    @Test
    public void resetTest(){
        int result = memberMapper.resetTryCount("kams1");
        System.out.println(result);
    }
    @Test
    public void selectTest(){
        for(int i=0; i<memberMapper.getList().size(); i++) {
            System.out.println(memberMapper.getList().get(i).getId());
        }
    }
    @Test
    public void authTest(){
        System.out.println(memberMapper.getAuth("kams2"));
    }





}
