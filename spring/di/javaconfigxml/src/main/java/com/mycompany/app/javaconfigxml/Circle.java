package com.mycompany.app.javaconfigxml;

//@Component
public class Circle implements IShape{

    private double radius;

    public Circle(){

    }

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14*radius*radius;
    }
}
