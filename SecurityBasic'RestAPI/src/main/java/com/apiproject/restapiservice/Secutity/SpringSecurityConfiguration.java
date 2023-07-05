package com.apiproject.restapiservice.Secutity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {



   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     //  1) All request should be authenticated
   //All request coming here
       http.authorizeHttpRequests(
            auth-> auth.anyRequest().authenticated()
    )  ;

     //  2) If a request is not authenticated,a web page shown
       //basic authentication
       http.httpBasic(withDefaults());

       //   3) CSRF -> POST,PUT

       http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

     /*  http.csrf(csrf -> csrf.disable());*/
       return http.build();

    }
}
