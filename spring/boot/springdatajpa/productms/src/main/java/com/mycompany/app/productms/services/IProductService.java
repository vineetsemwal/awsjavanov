package com.mycompany.app.productms.services;

import com.mycompany.app.productms.dtos.AddProductRequest;
import com.mycompany.app.productms.dtos.ProductDetails;
import com.mycompany.app.productms.dtos.UpdateProductRequest;
import com.mycompany.app.productms.entities.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
public interface IProductService {


    ProductDetails addProduct(@Valid AddProductRequest requestData);

    ProductDetails changePrice(@Valid UpdateProductRequest requestData);

    ProductDetails findProductDetailsById(@Min(1)long id);

    List<ProductDetails> findAll();


    List<ProductDetails>findProductsByPrice(double price);

    List<ProductDetails> findProductsGreaterThanPrice(@Min(1)double checkPrice);

    ProductDetails findProductByName(String name);
}
