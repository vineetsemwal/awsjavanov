package com.mycompany.app.productms.services;

import com.mycompany.app.productms.daos.IProductDao;
import com.mycompany.app.productms.daos.ProductDaoImpl;
import com.mycompany.app.productms.dtos.AddProductRequest;
import com.mycompany.app.productms.dtos.ProductDetails;
import com.mycompany.app.productms.dtos.UpdateProductRequest;
import com.mycompany.app.productms.entities.Product;
import com.mycompany.app.productms.exceptions.InvalidProductIdException;
import com.mycompany.app.productms.exceptions.InvalidProductNameException;
import com.mycompany.app.productms.exceptions.InvalidProductPriceException;
import com.mycompany.app.productms.exceptions.ProductNotFoundException;
import com.mycompany.app.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao dao ;

    @Autowired
    private ProductUtil productUtil;

    @Override
    public ProductDetails addProduct(AddProductRequest requestData) {
        String name = requestData.getName();
        double price = requestData.getPrice();
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product=dao.save(product);
        ProductDetails desired = productUtil.convert(product);
        return desired;
    }

    @Override
    public ProductDetails changePrice(UpdateProductRequest requestData) {
        long id = requestData.getId();
        double newPrice = requestData.getNewPrice();
         Product product = findById(id);
        product.setPrice(newPrice);
        product=dao.save(product);
        ProductDetails desired=productUtil.convert(product);
        return desired;
    }

    @Override
    public ProductDetails findProductDetailsById(long id) {
        Product product = findById(id);
        ProductDetails desired=productUtil.convert(product);
        return desired;
    }

    public Product findById(long id) {
        Product product = dao.findById(id);
        if(product==null){
            throw new ProductNotFoundException("product not found");
        }
        return product;
    }


    @Override
    public List<Product> findAll() {
        List<Product>list=dao.findAll();
        return list;
    }

    @Override
    public List<Product> findProductsGreaterThanPrice(double checkPrice) {
        List<Product>list=dao.findProductsGreaterThanPrice(checkPrice);
        return list;
    }


}
