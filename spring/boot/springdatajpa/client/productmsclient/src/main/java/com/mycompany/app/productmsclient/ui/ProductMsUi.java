package com.mycompany.app.productmsclient.ui;

import com.mycompany.app.productmsclient.dto.CreateProductRequest;
import com.mycompany.app.productmsclient.dto.ProductResponseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductMsUi {
    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8585";

    public void start() {
        System.out.println("Adding a product");
        CreateProductRequest request=new CreateProductRequest();
        request.setName("lg");
        request.setPrice(10000);
        ProductResponseDetails addResponse=addProductByExchange(request);
        System.out.println("product added, response received");
        display(addResponse);
        long productId=addResponse.getId();
        System.out.println("get product by id");
        ProductResponseDetails getResponse=getForEntityProductById(productId);
         display(getResponse);
    }

    public ProductResponseDetails getProductById(long productId) {
        String url = baseUrl + "/products/byid/" + productId;
        ProductResponseDetails details = restTemplate.getForObject(url, ProductResponseDetails.class);
        return details;
    }

    public ProductResponseDetails getForEntityProductById(long productId) {
        String url = baseUrl + "/products/byid/" + productId;
        ResponseEntity<ProductResponseDetails> responseEntity = restTemplate.getForEntity(url, ProductResponseDetails.class);
        ProductResponseDetails details=responseEntity.getBody();
        HttpStatus status=responseEntity.getStatusCode();
        System.out.println("response status="+status.name()+"http errno="+status.value());
        return details;
    }


    public ProductResponseDetails addProduct(CreateProductRequest requestData) {
        String url = baseUrl + "/products/add";
        ProductResponseDetails details = restTemplate.postForObject(url, requestData, ProductResponseDetails.class);
        return details;
    }

    public ProductResponseDetails addProductByExchange(CreateProductRequest requestData) {
        String url = baseUrl + "/products/add";
        HttpEntity requestEntity=new HttpEntity(requestData);
        Map<String,Object> parameters=new HashMap<>();
        ResponseEntity<ProductResponseDetails> responseEntity = restTemplate.exchange(url, HttpMethod.POST,requestEntity,ProductResponseDetails.class,parameters);
        ProductResponseDetails response=responseEntity.getBody();
        HttpStatus status=responseEntity.getStatusCode();
        System.out.println("response status="+status.name()+"http errno="+status.value());
        return response;
    }

    public ProductResponseDetails addProductByPostForEntity(CreateProductRequest requestData) {
        String url = baseUrl + "/products/add";
        HttpEntity requestEntity=new HttpEntity(requestData);
        ResponseEntity<ProductResponseDetails> responseEntity = restTemplate.postForEntity(url, requestEntity,ProductResponseDetails.class);
        ProductResponseDetails response=responseEntity.getBody();
        HttpStatus status=responseEntity.getStatusCode();
        System.out.println("response status="+status.name()+"http errno="+status.value());

        return response;
    }

    public void display(ProductResponseDetails details){
        System.out.println("product-"+details.getId()+"-"+details.getProductName()+"-"+details.getPrice());
    }


}
