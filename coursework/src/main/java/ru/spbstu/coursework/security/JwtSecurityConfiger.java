package ru.spbstu.coursework.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtSecurityConfiger extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private JwtTokenProvider jwtTokenProvider;
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    public JwtSecurityConfiger(JwtTokenProvider jwtTokenProvider, JwtAuthEntryPoint jwtAuthEntryPoint) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtAuthEntryPoint = jwtAuthEntryPoint;
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        JwtFilter jwtFilter = new JwtFilter(jwtTokenProvider, jwtAuthEntryPoint);
        builder.exceptionHandling().
                authenticationEntryPoint(new JwtAuthEntryPoint()).
                and().
                addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
