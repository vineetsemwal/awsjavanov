package com.mycompany.app.productms.services;

import com.mycompany.app.productms.daos.IProductDao;
import com.mycompany.app.productms.daos.ProductDaoImpl;
import com.mycompany.app.productms.entities.Product;
import com.mycompany.app.productms.exceptions.InvalidProductIdException;
import com.mycompany.app.productms.exceptions.InvalidProductNameException;
import com.mycompany.app.productms.exceptions.InvalidProductPriceException;
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

    @Override
    public Product addProduct(String name, double price) {
        validateProductName(name);
        validatePrice(price);
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product=dao.save(product);
        return product;
    }

    @Override
    public Product changePrice(long id, double newPrice) {
        validateId(id);
        validatePrice(newPrice);
        Product product = findById(id);
        product.setPrice(newPrice);
        dao.save(product);
        return product;
    }

    @Override
    public Product findById(long id) {
       validateId(id);
        Product product = dao.findById(id);
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

    void validatePrice(double price){
        if (price < 0) {
            throw new InvalidProductPriceException("price is invalid");
        }

    }

    void validateProductName(String name){
        if (name == null || name.isEmpty()) {
            throw new InvalidProductNameException("name is invalid");
        }
    }

    void validateId(long id){
        if (id <= 0) {
            throw new InvalidProductIdException("id is invalid");
        }
    }
}
