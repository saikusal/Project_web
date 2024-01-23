package com.sai.npci.shoply.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sai.npci.shoply.filters.JwtFilter;
import com.sai.npci.shoply.services.UserService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    JwtFilter jwtFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService();
    }
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                		.requestMatchers("/api/v1/user/login","/api/v1/product/create",
                				"/api/v1/user/fetch")
                		.permitAll()
                		.anyRequest().authenticated()
                		)
                	.sessionManagement(session->session
                			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                			)
                	.authenticationProvider(authenticationProvider())
                	.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                	.build();
                	
	                
    }

    

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

