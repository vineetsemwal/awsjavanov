package com.mycompany.app.productms.dtos;

public class UpdateProductRequest {
   private long id;
    private  double newPrice;

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
