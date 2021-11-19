package com.example.restdemo;

import com.example.restdemo.dto.AddProductRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@RestController
public class ProductController {

    private Map<Integer, Product> store = new HashMap<>();

    public ProductController() {
        Product product1 = new Product();
        product1.setId(1);
        product1.setPrice(1000);
        product1.setProductName("motorolla");
        store.put(1, product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setPrice(2000);
        product2.setProductName("samsung");
        store.put(2, product2);

    }

    /*
      ip:port/product/1
       ip:port/product/2

     */
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") int productId) {
        Product product = store.get(productId);
        return product;
    }

    @GetMapping("/products/all")
    public List<Product> allProducts() {
        Collection<Product> values = store.values();
        List<Product> list = new ArrayList<>();
        list.addAll(values);
        return list;
    }

    @PostMapping("/products/add")
    public String add(@RequestBody Product product) {
        store.put(product.getId(), product);
        return "product added";
    }

    @PutMapping("/products/update")
    public Product update(@RequestBody Product product) {
        store.put(product.getId(), product);
        return product;
    }

    @DeleteMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        store.remove(id);
        return "product removed";
    }
}
