package com.mypetalpot.LoginRegister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for testing purposes
                .csrf(csrf -> csrf.disable())

                // Permit login and register pages without authentication
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/register").permitAll() // Make login and register accessible to
                                                                            // everyone
                        .anyRequest().authenticated() // All other requests require authentication
                )

                // Configure form login
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Custom login page
                        .defaultSuccessUrl("/success", true) // After successful login, redirect to success page
                        .permitAll() // Permit all access to the login page
                )

                // Configure logout
                // .logout(logout -> logout
                //         .logoutUrl("/logout") // Custom logout URL
                //         .logoutSuccessUrl("/login?logout") // After logout, redirect to login page
                //         .permitAll() // Allow everyone to logout
                // );

        // Build the http security configuration
        return http.build();
    }

    // Optionally provide a UserDetailsService
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            throw new UsernameNotFoundException("User not found");
        };
    }
}
