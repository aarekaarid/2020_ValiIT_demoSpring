package com.example.demoSpring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").permitAll()   //if queried comes allow all users
                .anyRequest().permitAll()   //NB! for development ONLY!
//                .anyRequest().authenticated()   //any other must be authenticated
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
        http.cors();
        http.csrf().disable();
    }

    @Bean   //creates Spring bean and now we can use BCryptPasswordEncoder, cause Spring now knows
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
