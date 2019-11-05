package com.example.basedemo.local;

import com.example.basedemo.config.RootConfig;
import com.example.basedemo.config.WebConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BaseTest {

    @Test
    public void testScan() {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("beanName:" + beanName);
        }
    }
}
