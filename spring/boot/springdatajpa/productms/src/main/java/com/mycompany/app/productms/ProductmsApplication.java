package com.mycompany.app.productms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication equivalent to 3 annotation
 * 1) @Configuration
 * 2) @ComponentScan
 * 3)@EnableAutoConfiguration
 */
@OpenAPIDefinition(info=@Info(title="product management system",version = "1"))
@SpringBootApplication
public class ProductmsApplication {

    public static void main(String[] args) {
         SpringApplication.run(ProductmsApplication.class, args);

    }

}
