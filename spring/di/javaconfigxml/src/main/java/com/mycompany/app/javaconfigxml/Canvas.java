package com.mycompany.app.javaconfigxml;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Canvas {

    private IShape shape;


    public void setShape(IShape shape){
        this.shape = shape;
    }

    public IShape getShape(){
        return shape;
    }

    public void drawArea(){
       double area= shape.area();
        System.out.println("drawn area="+area);
    }


}
