package com.mycompany.app.javaconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Canvas {

    private IShape shape;

    @Autowired
    public void setShape(IShape shape){
        this.shape = shape;
    }


    public void drawArea(){
       double area= shape.area();
        System.out.println("drawn area="+area);
    }


}
