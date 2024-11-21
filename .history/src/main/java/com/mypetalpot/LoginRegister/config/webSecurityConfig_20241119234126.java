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
                                .formLogin()
                .loginPage("/api/users/login") // Custom login page
                .defaultSuccessUrl("/success", true) // Redirect to success page upon login
                .permitAll()
                                )
                                .logout(logout -> logout
                                                .permitAll() // Allow logout for all
                                );

                return http.build();
        }

}
