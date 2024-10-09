package com.example.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Consider enabling this in production
            .authorizeRequests()
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/stats/**").permitAll()
                .requestMatchers("/api/languages/**").permitAll()
                .requestMatchers("/api/states/**").permitAll()
                .requestMatchers("/api/commodity-group/**").permitAll()
                .requestMatchers("/api/procurement-types/**").permitAll()
                .requestMatchers("/api/categories/**").permitAll()
                .requestMatchers("/api/ownership-types/**").permitAll()
                .requestMatchers("/api/commodity-forms/**").permitAll()
                .requestMatchers("/api/measurement-units/**").permitAll()
                .requestMatchers("/api/colors/**").permitAll()
                .requestMatchers("/api/cropseasons/**").permitAll()
                .requestMatchers("/api/modules/**").permitAll()
                .requestMatchers("/api/commodities/**").permitAll()
                // Allow access to /api/auth endpoints
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/user/**").hasAuthority("ROLE_VIEWER")
                .requestMatchers("/editor/**").hasAuthority("ROLE_EDITOR")
                .anyRequest().authenticated() // Enforce authentication for all other endpoints
            .and()
            .formLogin()
                .loginPage("/official-login") // Custom login page, ensure route exists
                .permitAll()
            .and()
            .logout()
                .permitAll();
        
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}