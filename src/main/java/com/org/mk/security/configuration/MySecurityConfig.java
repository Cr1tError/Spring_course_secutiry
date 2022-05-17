package com.org.mk.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void configure(AuthenticationManagerBuilder amb) throws Exception {

        amb.jdbcAuthentication().dataSource(dataSource);

//      UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//      amb.inMemoryAuthentication()
//              .withUser(userBuilder.username("Maks")
//                      .password("user")
//                      .roles("EMPLOYEE"))
//              .withUser(userBuilder.username("Ivan")
//                      .password("user")
//                      .roles("HR"))
//              .withUser(userBuilder.username("Oleg")
//                      .password("user")
//                      .roles("MANAGER", "HR"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info/**").hasRole("MANAGER")
                .and().formLogin().permitAll();

    }
}
