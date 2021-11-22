package com.mycompany.app.productms.dtos;

import javax.validation.constraints.Min;

public class UpdateProductRequest {
    @Min(1)
    private long id;
    @Min(1)
    private double newPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
}
