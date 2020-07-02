package com.gemellaro.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Value(value= "${feign-customer.username}")
    private String username;

    @Value(value= "${feign-customer.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        System.out.println("Utenze di Basic Auth Feign -> User: "+username + " password: "+password);
        return new BasicAuthRequestInterceptor(username, password);
    }
}
