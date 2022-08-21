package com.example.springsecuritydemo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConf extends WebSecurityConfigurerAdapter {


  //créer un encodeur
  @Bean
  public static PasswordEncoder getPassEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/").permitAll() //access without authentication
            .antMatchers(HttpMethod.GET, "/users/**").hasRole("admin") //access with authentication
            .antMatchers(HttpMethod.GET, "/posts/**").permitAll()//access without authentication
            .and()
            .formLogin()
            .and()
            .logout().permitAll()
            .and()
            .csrf().disable()
            .httpBasic();
  }

  @Resource
  DataSource datasource;
  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    UserDetails student = User.builder()
            .username("Ny Hasina")
            .password(getPassEncoder().encode("password"))
            .roles("student")
            .build();

    UserDetails admin = User.builder()
            .username("Admin")
            .password(getPassEncoder().encode("admin"))
            .roles("admin")
            .build();

    JdbcUserDetailsManager manager = new JdbcUserDetailsManager(datasource);
    manager.createUser(admin);
    manager.createUser(student);
    return manager;
  }
}
