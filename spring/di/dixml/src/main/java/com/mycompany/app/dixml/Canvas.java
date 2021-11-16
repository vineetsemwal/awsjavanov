package com.mycompany.app.dixml;


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
