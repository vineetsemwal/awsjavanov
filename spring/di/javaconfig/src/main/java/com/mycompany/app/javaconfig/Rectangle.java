package com.mycompany.app.javaconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public class Rectangle implements IShape{

    @Value("${rect.length}")
    private double length;

    @Value("${rect.breadth}")
    private double breadth;

    public Rectangle(){

    }

    public Rectangle(double length, double breadth){
        this.length = length;
        this.breadth=breadth;
        System.out.println("in rectangle constructor, length="+this.length+" breadth="+this.breadth);
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("inside  Rectangle's afterinit, length="+length+" breadth="+breadth);
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    @Override
    public double area(){
        return length*breadth;
    }


}
