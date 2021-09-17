package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.MemberVo;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;


    Date date = new Date();


    @Test
    public void mapperTest(){
       ArrayList<MemberVo> test = memberMapper.findByUserId("kams1");
       System.out.println(test.get(0).getEnable());
       System.out.println(test.get(0).getTryNum());

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




}
