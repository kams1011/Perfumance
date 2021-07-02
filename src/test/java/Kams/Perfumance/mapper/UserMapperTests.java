package Kams.Perfumance.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTests {
    @Autowired(required = false)
    private UserMapper uMapper;



    @Test
    public void getListTest(){
        uMapper.getList();
    }


}
