package com.mycompany.app.javaconfig;

public class Canvas {

    private Rectangle rectangle=new Rectangle(4,5);


    public void drawArea(){
       double area= rectangle.area();
        System.out.println("drawn area="+area);
    }


}
