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
                                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                                                .requestMatchers("/api/users/login", "/api/users/register")
                                                .permitAll() // Allow public access
                                                // to login/register
                                                // and static resources
                                                .anyRequest().authenticated() // All other requests require
                                                                              // authentication
                                )
                                .formLogin(formLogin -> formLogin
                                                .loginPage("/login") // Custom login page
                                                stom login page
                
                                                .permitAll() // Allow access to the login page for all
                                )
                                .logout(logout -> logout
                                                .permitAll() // Allow logout for all
                                );

                return http.build();
        }

}
