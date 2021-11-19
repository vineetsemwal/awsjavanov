package com.mycompany.app.productms.daos;

import com.mycompany.app.productms.entities.Product;

import java.util.List;

public interface  IProductDao {

    Product save(Product product);

    Product findById(long id);

    List<Product> findAll();

    List<Product> findProductsGreaterThanPrice(double checkPrice);
}
