package com.mycompany.app.productms.util;

import com.mycompany.app.productms.dtos.ProductDetails;
import com.mycompany.app.productms.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductUtil {

    public ProductDetails convert(Product product){
        ProductDetails desired=new ProductDetails();
        desired.setId(product.getId());
        desired.setProductName(product.getName());
        desired.setPrice(product.getPrice());
        return desired;
    }

    public List<ProductDetails>covertToDetailsList(Collection<Product>products){
     // products.stream().map(product->convert(product)).collect(Collectors.toList());
        List<ProductDetails>desired=new ArrayList<>();
        for (Product product: products){
           ProductDetails details= convert(product);
           desired.add(details);
        }
        return desired;
    }

}
