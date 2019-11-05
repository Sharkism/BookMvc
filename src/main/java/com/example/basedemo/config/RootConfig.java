package com.example.basedemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import sun.security.krb5.Config;

@Configuration
@Import(DataConfig.class)
@ComponentScan(value = "com.example.basedemo",
excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
})
public class RootConfig {
}
