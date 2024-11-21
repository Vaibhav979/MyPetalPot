package com.mypetalpot.LoginRegister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers("/api/users/login", "/api/users/register", "/css/**", "/js/**").permitAll() // Allow login and register
                    .anyRequest().authenticated() // Protect other URLs
                .and()
                .formLogin()
                    .loginPage("/api/users/login") // Specify custom login page
                    .defaultSuccessUrl("/success", true) // Redirect to success page upon login
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/api/users/login?logout") // Redirect to login after logout
                    .permitAll();
        }
}