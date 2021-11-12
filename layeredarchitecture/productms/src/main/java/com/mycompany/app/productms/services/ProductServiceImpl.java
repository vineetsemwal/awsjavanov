package com.mycompany.app.productms.services;

import com.mycompany.app.productms.daos.IProductDao;
import com.mycompany.app.productms.daos.ProductDaoImpl;
import com.mycompany.app.productms.entities.Product;
import com.mycompany.app.productms.exceptions.InvalidProductIdException;
import com.mycompany.app.productms.exceptions.InvalidProductNameException;
import com.mycompany.app.productms.exceptions.InvalidProductPriceException;

public class ProductServiceImpl implements IProductService {

    private IProductDao dao = new ProductDaoImpl();

    private long generatedId;

    public long generateId() {
        ++generatedId;
        return generatedId;
    }


    @Override
    public Product addProduct(String name, double price) {
        validateProductName(name);
        validatePrice(price);
        long id = generateId();
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        dao.save(product);
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
