package Kams.Perfumance.security;

import Kams.Perfumance.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration //이 클래스로 각종 설정을 하겠다.
@EnableWebSecurity // Spring Security를 설정할 클래스라고 정의.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    SecurityService homeService;

    @Bean //회원가입시 비밀번호 암호화.
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean //실제 인증을 한 이후 인증이 완료되면 Authentication객체 반환.
    public DaoAuthenticationProvider authenticationProvider(SecurityService homeService){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(homeService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override //Home 디렉토리 하위 파일 목록은 항상 통과
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/home/**");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/home/**").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin();

//        http.formLogin();
        http.exceptionHandling().accessDeniedPage("/accessDenied"); //에러페이지로 이동
        http.logout().logoutUrl("/logout").invalidateHttpSession(true);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
     auth.authenticationProvider(authenticationProvider(homeService));
    }



}
