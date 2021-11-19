package com.mycompany.app.productms.util;

import com.mycompany.app.productms.dtos.ProductDetails;
import com.mycompany.app.productms.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductUtil {

    public ProductDetails convert(Product product){
        ProductDetails desired=new ProductDetails();
        desired.setId(product.getId());
        desired.setProductName(product.getName());
        desired.setPrice(product.getPrice());
        return desired;
    }

}
