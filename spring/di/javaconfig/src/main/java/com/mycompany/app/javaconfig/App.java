package com.mycompany.app.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

    public static void main(String[] args){
        AbstractApplicationContext context=new AnnotationConfigApplicationContext(JavaConfiguration.class);

        Canvas canvas=context.getBean("canvas",Canvas.class);
        System.out.println("using canvas to draw shape");
        canvas.drawArea();
        IShape shape1=context.getBean(IShape.class);
        System.out.println("shape="+shape1 + "area="+shape1.area());
        Rectangle rect=context.getBean(Rectangle.class);
        boolean isShapeSame=shape1==rect;
        System.out.println("same rectangle object?="+isShapeSame);
        context.close();
        System.out.println("bye");
    }

}
