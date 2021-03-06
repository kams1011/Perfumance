package Kams.Perfumance.security;

import Kams.Perfumance.handler.CustomAuthenticationFailureHandler;
import Kams.Perfumance.handler.CustomAuthenticationSuccessHandler;
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
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;

@Configuration //이 클래스로 각종 설정을 하겠다.
@EnableWebSecurity // Spring Security를 설정할 클래스라고 정의. -> 자동으로 springSecurityFilterChain이 포함됨.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;

    @Autowired
    private CustomAuthenticationFailureHandler failureHandler;

    @Bean //회원가입시 비밀번호 암호화.
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override //css는 항상 통과
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**");
    }

    @Override // HTTP 보안
    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/home/**","/access/**").permitAll()
                .antMatchers("https://dapi.kakao.com/v2/local/search/**").permitAll()
                .and()
             .authorizeRequests()
                .antMatchers("/board/**","/user/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
             .formLogin()
                .loginPage("/access/login")
                .permitAll()
               .loginProcessingUrl("/login-process") // post로 로그인 정보를 보낼시 경로.
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
             .exceptionHandling().accessDeniedPage("/access/denied")//에러페이지로 이동
                .and()
             .logout()
                .permitAll();

    }

    @Autowired //사용자 인증정보
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource) //JDBC // application.properties에 있는 datasource를 사용하겠다.
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
