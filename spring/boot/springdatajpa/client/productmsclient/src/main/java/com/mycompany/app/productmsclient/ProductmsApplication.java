package com.mycompany.app.productmsclient;

import com.mycompany.app.productmsclient.ui.ProductMsUi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductmsApplication {

    public static void main(String[] args) {
        ApplicationContext context =SpringApplication.run(ProductmsApplication.class, args);
        ProductMsUi ui=context.getBean(ProductMsUi.class);
        ui.start();
    }

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate= new RestTemplate();
        return restTemplate;
    }
}
