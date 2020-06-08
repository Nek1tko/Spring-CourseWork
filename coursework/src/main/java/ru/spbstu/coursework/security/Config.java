package ru.spbstu.coursework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().disable().formLogin().disable().
                exceptionHandling().authenticationEntryPoint(new JwtAuthEntryPoint()).
                and().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().
                authorizeRequests().
                antMatchers("/carservice/auth/signin").permitAll().
                antMatchers(HttpMethod.POST).hasRole("ADMIN").
                antMatchers(HttpMethod.DELETE).hasRole("ADMIN").
                antMatchers("/carservice/**").authenticated().
                and().
                apply(new JwtSecurityConfiger(jwtTokenProvider));
    }
}
