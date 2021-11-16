package com.mycompany.app.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args){
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfiguration.class);
        Canvas canvas=context.getBean(Canvas.class);
        System.out.println("using canvas to draw shape");
        canvas.drawArea();
        Rectangle shape=context.getBean(Rectangle.class);
        System.out.println("shape="+shape +" length="+shape.getLength()+" breadth="+shape.getBreadth());
    }

}
