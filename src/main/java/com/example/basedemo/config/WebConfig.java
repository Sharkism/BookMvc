package com.example.basedemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(value = "com.example.basedemo.controller")
public class WebConfig implements WebMvcConfigurer {
}
