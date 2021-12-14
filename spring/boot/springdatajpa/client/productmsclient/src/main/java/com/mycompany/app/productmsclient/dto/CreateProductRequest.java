package com.mycompany.app.productmsclient.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

public class CreateProductRequest {
    private String name;

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
