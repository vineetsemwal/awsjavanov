package com.example.restdemo;

import com.example.restdemo.dto.AddProductRequest;
import com.example.restdemo.dto.ProductDetails;
import com.example.restdemo.dto.UpdateProductRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductControllerImproved {

    private Map<Integer, Product> store = new HashMap<>();

    private int generatedId;

    public int generateId(){
        return ++generatedId;
    }
    public ProductControllerImproved() {
        Product product1 = new Product();
        int id1=generateId();
        product1.setId(id1);
        product1.setPrice(1000);
        product1.setProductName("motorolla");
        store.put(id1, product1);

        int id2=generateId();
        Product product2 = new Product();
        product2.setId(id2);
        product2.setPrice(2000);
        product2.setProductName("samsung");
        store.put(id2, product2);

    }

    /*
      ip:port/product/1
       ip:port/product/2

     */
    @GetMapping("/products/byid/{id}")
    public ProductDetails getProductById(@PathVariable("id") int productId) {
        Product product = store.get(productId);
        ProductDetails response= convert(product);
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
        Product product=new Product();
        String name= requestData.getName();
        product.setProductName(name);
        double price=requestData.getPrice();
        product.setPrice(price);
        int id=generateId();
        product.setId(id);
        store.put(product.getId(), product);

        ProductDetails desired=convert(product);
        return desired;
    }

    @PutMapping("/products/price/change")
    public ProductDetails changePrice(@RequestBody UpdateProductRequest requestData ) {
        int id= requestData.getId();
        Product product=store.get(id);
        double newPrice=requestData.getNewPrice();
        product.setPrice(newPrice);
        ProductDetails response=convert(product);
        return response;
    }

    @DeleteMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        store.remove(id);
        return "product removed";
    }

    ProductDetails convert(Product product){
        ProductDetails desired=new ProductDetails();
        desired.setId(product.getId());
        desired.setProductName(product.getProductName());
        desired.setPrice(product.getPrice());
        return desired;
    }
}
