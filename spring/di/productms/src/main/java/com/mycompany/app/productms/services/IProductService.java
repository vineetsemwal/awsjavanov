package com.mycompany.app.productms.services;

import com.mycompany.app.productms.entities.Product;

public interface IProductService {
    Product addProduct(String name, double price);

    Product changePrice(long id, double newPrice);

    Product findById(long id);

}
