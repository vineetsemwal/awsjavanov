package com.mycompany.app.productms.controllers;

import com.mycompany.app.productms.dtos.AddProductRequest;
import com.mycompany.app.productms.dtos.ProductDetails;
import com.mycompany.app.productms.dtos.UpdateProductRequest;
import com.mycompany.app.productms.entities.Product;
import com.mycompany.app.productms.services.IProductService;
import com.mycompany.app.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductControllerImproved {

    @Autowired
    private IProductService service;
    @Autowired
    private ProductUtil productUtil;

    /*
      ip:port/product/1
       ip:port/product/2

     */
    @GetMapping("/products/byid/{id}")
    public ProductDetails getProductById(@PathVariable("id") long productId) {
        Product product = service.findById(productId);
        ProductDetails response = productUtil.convert(product);
        return response;
    }

    /*
        @GetMapping("/products/all")
        public List<Product> allProducts() {
            Collection<Product> values = store.values();
            List<Product> list = new ArrayList<>();
            list.addAll(values);
            return list;
        }
    */
    @PostMapping("/products/add")
    public ProductDetails add(@RequestBody AddProductRequest requestData) {
        String name = requestData.getName();
        double price = requestData.getPrice();
        Product product = service.addProduct(name, price);
        ProductDetails desired = productUtil.convert(product);
        return desired;
    }

    @PutMapping("/products/price/change")
    public ProductDetails changePrice(@RequestBody UpdateProductRequest requestData) {
        long id = requestData.getId();
        double newPrice = requestData.getNewPrice();
        Product product = service.changePrice(id, newPrice);
        ProductDetails response = productUtil.convert(product);
        return response;
    }

}
