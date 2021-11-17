package com.mycompany.app.productms;

import com.mycompany.app.productms.frontend.ProductUi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String args[]){
      ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
      ProductUi productUi=context.getBean(ProductUi.class);
      productUi.start();
    }

}
