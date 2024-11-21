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
                                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity (only for testing)
                                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                                                .requestMatchers("/api/users/login", "/api/users/register").permitAll() // Allow
                                                                                                                        // public
                                                                                                                        // access
                                                                                                                        // to
                                                                                                                        // login/register
                                                .anyRequest().authenticated()  requests require
                                                                              // authentication
                                )
                                .formLogin(formLogin -> formLogin
                                                .loginPage("/api/users/login") 
                                                .defaultSuccessUrl("/success", true)
                                                .permitAll() 
                                );

                return http.build();
        }
}