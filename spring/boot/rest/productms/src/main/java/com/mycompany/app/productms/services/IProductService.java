package com.mycompany.app.productms.services;

import com.mycompany.app.productms.dtos.AddProductRequest;
import com.mycompany.app.productms.dtos.ProductDetails;
import com.mycompany.app.productms.dtos.UpdateProductRequest;
import com.mycompany.app.productms.entities.Product;

import java.util.List;

public interface IProductService {
    ProductDetails addProduct(AddProductRequest requestData);

    ProductDetails changePrice(UpdateProductRequest requestData);

    ProductDetails findProductDetailsById(long id);

    List<Product> findAll();

    List<Product> findProductsGreaterThanPrice(double checkPrice);
}
