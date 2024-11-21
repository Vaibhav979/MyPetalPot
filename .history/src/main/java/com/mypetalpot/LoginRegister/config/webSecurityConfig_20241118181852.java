package com.mypetalpot.LoginRegister.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/register").permitAll() 
                .anyRequest().authenticated() 
                .and()
                .formLogin()
                .loginPage("/login") // Custom login page URL
                .permitAll() // Allow everyone to access the login page
                .and()
                .logout()
                .permitAll();
    }
}
