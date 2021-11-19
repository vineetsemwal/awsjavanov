package com.mycompany.app.productms;

import com.mycompany.app.productms.frontend.ProductUi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @SpringBootApplication equivalent to 3 annotation
 * 1) @Configuration
 * 2) @ComponentScan
 * 3)@EnableAutoConfiguration
 */

@SpringBootApplication
public class ProductmsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProductmsApplication.class, args);

    }

}
