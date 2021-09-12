package Kams.Perfumance.security;

import Kams.Perfumance.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration //이 클래스로 각종 설정을 하겠다.
@EnableWebSecurity // Spring Security를 설정할 클래스라고 정의. -> 자동으로 springSecurityFilterChain이 포함됨.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Bean //회원가입시 비밀번호 암호화.
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean //실제 인증을 한 이후 인증이 완료되면 Authentication객체 반환. 화면에서 입력한 로그인정보와 DB에서 가져온 사용자 정보 비교
    public DaoAuthenticationProvider authenticationProvider(SecurityService securityService){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(securityService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override //Home 디렉토리 하위 파일 목록은 항상 통과
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/home/**","/access/**").permitAll()
                .and()
             .authorizeRequests()
                .antMatchers("/board/**","/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
             .formLogin()
                .loginPage("/access/login")
                .permitAll()
               .loginProcessingUrl("/login-process") // post로 로그인 정보를 보낼시 경로.
                .defaultSuccessUrl("/home/main", true) //로그인 성공 이후 이동할 페이지
                .and()
             .logout()
                .permitAll();
//                .successHandler(new CustomAuthenticationSuccessHandler("/main"))
//                .failureUrl("login-fail");
//                .failureHandler(new CustomAuthenticationFailureHandler("/login-fail"))



        http.exceptionHandling().accessDeniedPage("/accessDenied"); //에러페이지로 이동
//        http.logout().logoutUrl("/logout").invalidateHttpSession(true);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select id,pwd,enabled "
                        + "from user_info "
                        + "where id = ?")
                .authoritiesByUsernameQuery("select ui.id, r.role "
                        + "from user_role ur inner join user_info ui on ur.uno = ui.uno "
                        + "inner join role r on ur.rno = r.rno "
                        + "where ui.id = ?");
    }




}
