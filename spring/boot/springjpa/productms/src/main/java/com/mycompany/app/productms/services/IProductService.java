package com.mycompany.app.productms.services;

import com.mycompany.app.productms.entities.Product;

import java.util.List;

public interface IProductService {
    Product addProduct(String name, double price);

    Product changePrice(long id, double newPrice);

    Product findById(long id);

    List<Product> findAll();

    List<Product> findProductsGreaterThanPrice(double checkPrice);
}
