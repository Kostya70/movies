package com.movie.movies.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource); //говорим спрингу что нужно брать информацию о юзерах из базы данных

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api").hasAnyRole("ADMIN")
                .antMatchers("/api").hasRole("ADMIN")
                .antMatchers("/movies").hasRole("REVIEW")
                .antMatchers("/movies").hasRole("ADMIN")
                .antMatchers("/movies/*").hasRole("ADMIN")
                .and()
                .formLogin().permitAll();
    }
}
