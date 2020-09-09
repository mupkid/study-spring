package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定义用户信息服务（查询用户信息）
     */
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("$2a$10$73vcJN58QSmYGyPtTF4RR.Tyy5ogfLg1G67z/bwcol96NRItclOrS").roles("USER").build());
        manager.createUser(User.withUsername("zhangsan").password("$2a$10$9KS8WGuPY1B1w6cw67V3xeJ4.dChfoIoBuUO.hOPJqZMj/oo2XHe6").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("$2a$10$tGKOlmBQOTNhey8v9XZr0uYpmkYyJJZLLMBnSf2wYBDLzYPlsVau2").authorities("p2").build());
        return manager;
    }

    /**
     * 密码编码器
     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 安全拦截机制
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/r/r1").hasAnyAuthority("p1")
//                .antMatchers("/r/r2").hasAnyAuthority("p2")
//                // 所有/r/**的请求必须认证通过
//                .antMatchers("/r/**").authenticated()
//                // 除了/r/**，其他的请求可以访问
//                .anyRequest().permitAll()
//                .and()
//                //允许表单登录
//                .formLogin()
//                //自定义登录成功的页面地址
//                .successForwardUrl("/login-success");
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authorize) -> authorize
                                .antMatchers("/css/**", "/index").permitAll()
                                .antMatchers("/user/**").hasRole("USER")
//                        .antMatchers("/r/r1").hasAnyAuthority("p1")
//                        .antMatchers("/r/r2").hasAnyAuthority("p2")
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .failureUrl("/login-error")
                );
    }
}
