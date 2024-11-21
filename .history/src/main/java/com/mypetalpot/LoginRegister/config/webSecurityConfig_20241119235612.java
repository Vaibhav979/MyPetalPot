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
                                                .anyRequest().authenticated() // All other requests require
                                                                              // authentication
                                )
                                .formLogin(formLogin -> formLogin
                                                .loginPage("/api/users/login") 
                                                .defaultSuccessUrl("/success", true)
                                                .permitAll() // Allow access to login for everyone
                                )
                                .logout(logout -> logout
                                                .logoutUrl("/api/users/logout") // Custom logout URL if needed
                                                .logoutSuccessUrl("/api/users/login?logout") // Redirect to login page
                                                                                             // after logout
                                                .permitAll() // Allow logout for all
                                );

                return http.build();
        }
}
