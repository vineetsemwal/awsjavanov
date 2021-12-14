package com.mycompany.app.productmsclient.ui;

import com.mycompany.app.productmsclient.dto.CreateProductRequest;
import com.mycompany.app.productmsclient.dto.ProductResponseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductMsUi {
    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8585";

    public void start() {
        System.out.println("Adding a product");
        CreateProductRequest request=new CreateProductRequest();
        request.setName("samsung");
        request.setPrice(10000);
        ProductResponseDetails addResponse=addProduct(request);
        System.out.println("product added, response received");
        display(addResponse);
        long productId=addResponse.getId();
        System.out.println("get product by id");
        ProductResponseDetails getResponse=getProductById(productId);
         display(getResponse);
    }

    public ProductResponseDetails getProductById(long productId) {
        String url = baseUrl + "/products/byid/" + productId;
        ProductResponseDetails details = restTemplate.getForObject(url, ProductResponseDetails.class);
        return details;
    }

    public ProductResponseDetails addProduct(CreateProductRequest requestData) {
        String url = baseUrl + "/products/add";
        ProductResponseDetails details = restTemplate.postForObject(url, requestData, ProductResponseDetails.class);
        return details;
    }

    public void display(ProductResponseDetails details){
        System.out.println("product-"+details.getId()+"-"+details.getProductName()+"-"+details.getPrice());
    }


}
