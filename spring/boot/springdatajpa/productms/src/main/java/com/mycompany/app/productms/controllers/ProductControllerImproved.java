package com.mycompany.app.productms.controllers;

import com.mycompany.app.productms.dtos.AddProductRequest;
import com.mycompany.app.productms.dtos.ProductDetails;
import com.mycompany.app.productms.dtos.UpdateProductRequest;
import com.mycompany.app.productms.services.IProductService;
import com.mycompany.app.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


@RequestMapping("/products")
@Validated
@RestController
public class ProductControllerImproved {

    @Autowired
    private IProductService service;
    @Autowired
    private ProductUtil productUtil;

   /*
     /products/byid/5
    */
   // @RequestMapping(path = "/byid/{id}",method=RequestMethod.GET)
    @GetMapping(value = "/byid/{id}")
    public ProductDetails getProductById(@PathVariable("id")long productId) {
        ProductDetails response = service.findProductDetailsById(productId);
         return response;
    }

    /*
    @GetMapping("/byid2/{id}")
    public ResponseEntity<ProductDetails> getProductById2(@PathVariable("id")long productId) {
        ProductDetails products = service.findProductDetailsById(productId);
        ResponseEntity<ProductDetails>response=new ResponseEntity<>(products,HttpStatus.OK);
        return response;
    }
    */


    /*
        @GetMapping("/products/all")
        public List<Product> allProducts() {
            Collection<Product> values = store.values();
            List<Product> list = new ArrayList<>();
            list.addAll(values);
            return list;
        }
    */
    @ResponseStatus(HttpStatus.CREATED)
    //@RequestMapping(path ="/add", method=RequestMethod.POST)
    @PostMapping("/add")
    public ProductDetails add(@RequestBody  AddProductRequest requestData) {
        ProductDetails response = service.addProduct(requestData);
        return response;
    }

    @PutMapping("/price/change")
    public ProductDetails changePrice(@RequestBody  UpdateProductRequest requestData) {
        ProductDetails response= service.changePrice(requestData);
        return response;
    }

    @GetMapping("/greater/byprice/{price}")
    public List<ProductDetails>fetchProductsGreaterThanPrice(@PathVariable double price){
       List<ProductDetails>response=  service.findProductsGreaterThanPrice(price);
       return response;
    }

}
