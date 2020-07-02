package com.gemellaro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/rest/info")
public class InfoController {

    @Value("${info.customerservice.name}")
    private String name;
    @Value("${info.customerservice.email}")
    private String email;
    @Value("${info.customerservice.phone}")
    private String phone;

    @GetMapping("/support")
    public String getSupportInfo() {
        return "Name: " + name + " Email: " + email + " Phone: " + phone;
    }


}

