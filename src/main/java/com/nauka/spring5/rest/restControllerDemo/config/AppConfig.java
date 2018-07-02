package com.nauka.spring5.rest.restControllerDemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.nauka.spring5.rest.restControllerDemo")
public class AppConfig {}