package Kams.Perfumance.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTests {

    @Autowired
    UserServiceImpl userService;


    @Test
    public void selectTest(){
        System.out.println(userService.getAllUser());
    }
}
