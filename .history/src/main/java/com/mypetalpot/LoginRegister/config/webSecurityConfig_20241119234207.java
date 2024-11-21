package com.mypetalpot.LoginRegister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeRequests()
                                .antMatchers("/api/users/register", "/api/users/login").permitAll() // Allow access to
                                                                                                    // login and
                                                                                                    // register pages
                                .anyRequest().authenticated() // All other URLs require authentication
                                .and()
                                .formLogin()
                                .loginPage("/api/users/login") // Custom login page
                                .defaultSuccessUrl("/success", true) // Redirect to success page upon login
                                .permitAll()
                                .and()
                                .logout()
                                .permitAll();
        }

}
