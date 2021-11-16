package com.mycompany.app.javaconfigxml;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Rectangle implements IShape{


    private double length;

    private double breadth;

    public Rectangle(){

    }

    public Rectangle(double length, double breadth){
        this.length = length;
        this.breadth=breadth;
        System.out.println("in rectangle constructor, length="+this.length+" breadth="+this.breadth);
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
