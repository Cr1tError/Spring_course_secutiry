package com.org.mk.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder amb) throws Exception {
      UserBuilder userBuilder = User.withDefaultPasswordEncoder();

      amb.inMemoryAuthentication()
              .withUser(userBuilder.username("Maks")
                      .password("user")
                      .roles("EMPLOYEE"))
              .withUser(userBuilder.username("Ivan")
                      .password("user")
                      .roles("HR"))
              .withUser(userBuilder.username("Oleg")
                      .password("user")
                      .roles("MANAGER", "HR"));

    }
}
