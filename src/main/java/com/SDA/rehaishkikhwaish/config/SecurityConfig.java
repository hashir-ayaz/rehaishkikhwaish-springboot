package com.SDA.rehaishkikhwaish.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Value;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Value("${spring.security.user.name}")
    private String securityUsername;
    @Value("${spring.security.user.password}")
    private String securityPassword;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        UserDetails user = User.withUsername(securityUsername)
                .password(passwordEncoder.encode(securityPassword))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());

        return http.build();
    }
}
