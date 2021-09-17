package Kams.Perfumance.handler;

import Kams.Perfumance.service.SecurityService;
import Kams.Perfumance.service.UserService;
import Kams.Perfumance.service.UserServiceImpl;
import Kams.Perfumance.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

//    @Autowired
//    SecurityService securityService;


    @Autowired
    UserServiceImpl userService;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String id=request.getParameter("username");
        ArrayList<MemberVo> loginUser=userService.getUserInfo(id);
        int tryNum = loginUser.get(0).getTryNum();

        if(tryNum<6){
           userService.checkTryCount(id);
           request.setAttribute("failCount", tryNum);
           request.getRequestDispatcher("/access/login").forward(request, response);
        }else{
            userService.userDisabled(id);
            System.out.println("계정이 비활성화됐습니다.");
        }

        System.out.println(id);
        System.out.println(tryNum);
        //이제 여기서 실패하면 trynum하나씩 증가시킴. 근데 trynum이 세개가 되면 enabled를 false로 만듬.
    }
}
