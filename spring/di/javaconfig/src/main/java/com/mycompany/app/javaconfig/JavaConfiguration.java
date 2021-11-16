package com.mycompany.app.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.mycompany.app.javaconfig")
@Configuration
public class JavaConfiguration {

    @Bean
    public Rectangle rectangle(){
        Rectangle rect=new Rectangle(3,4);
        return rect;
    }


}
