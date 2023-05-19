package com.jpa.schoolDirectory.securityConfigurations;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class AppSecurityConfigurations {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){
        return new JdbcUserDetailsManager(datasource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employee/**").hasRole("ADMIN")
                );

        http.httpBasic();

        //CrossSystemRequestForgery not required for stateless REST APIs, so it can be disabled
        http.csrf().disable();

        return http.build();
    }
}
