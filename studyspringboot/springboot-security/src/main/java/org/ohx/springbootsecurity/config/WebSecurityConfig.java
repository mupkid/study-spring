package org.ohx.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 安全拦截机制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authorize) -> authorize
                        .antMatchers("/css/**", "/index").permitAll()
                        .antMatchers("/user/**").hasRole("USER")
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .failureUrl("/login-error")
                );
    }
}
