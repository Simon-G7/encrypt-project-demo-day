package com.example.aesencryption.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${spring.security.debug:false}")
    boolean securityDebug;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/encryption/user")
                .hasAnyRole("ADMIN","USER")
                .requestMatchers(HttpMethod.DELETE,"/encryption/*")
                .hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/encryption/*")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.debug(securityDebug)
                .ignoring()
                .requestMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
    }
}
