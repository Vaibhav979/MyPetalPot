package com.mypetalpot.LoginRegister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
                        .requestMatchers("/login", "/register", "/success").permitAll() // Make login, register, and
                                                                                        // success accessible to
                                                                                        // everyone
                        .anyRequest().authenticated() // All other requests require authentication
                )

                // Configure form login
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Custom login page
                        .defaultSuccessUrl("/success", true) // After successful login, redirect to success page
                        .failureUrl("/login?error=true") // Redirect to login with error param on failure
                        .permitAll() // Permit all access to the login page
                )

                // Configure logout
                .logout(logout -> logout
                        .logoutUrl("/logout") // Custom logout URL
                        .logoutSuccessUrl("/login?logout") // After logout, redirect to login page
                        .invalidateHttpSession(true) // Invalidate session
                        .deleteCookies("JSESSIONID") // Delete cookies on logout
                        .permitAll() // Allow everyone to logout
                )

                // Session management to prevent continuous redirection
                .sessionManagement(session -> session
                        .invalidSessionUrl("/login?invalidSession=true") // Redirect to login page if session is invalid
                        .maximumSessions(1) // Allow only one session per user
                        .expiredUrl("/login?expired=true") // Redirect to login if session expires
                );

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
