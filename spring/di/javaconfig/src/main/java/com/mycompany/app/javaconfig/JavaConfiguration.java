package com.mycompany.app.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@PropertySource("classpath:app.properties")
@ComponentScan("com.mycompany.app.javaconfig")
@Configuration
public class JavaConfiguration {


    @Bean
    public Rectangle rectangle(){
        Rectangle rect=new Rectangle(3,4);
        return rect;
    }


}
