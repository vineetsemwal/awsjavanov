package com.mycompany.app.productms.daos;

import com.mycompany.app.productms.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductDaoImpl implements IProductDao {

    @PersistenceContext
    //@Autowired
    private EntityManager em;

    @Override
    public Product save(Product product) {
        product = em.merge(product);
        return product;
    }

    @Override
    public Product findById(long id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    @Override
    public List<Product> findAll() {
        String queryStr = "from Product";
        // id, name, price
        TypedQuery<Product> query = em.createQuery(queryStr, Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    @Override
    public List<Product> findProductsGreaterThanPrice(double checkPrice) {
        String queryStr = "from Product where price >:check";
        TypedQuery<Product> query = em.createQuery(queryStr, Product.class);
        query.setParameter("check", checkPrice);
        List<Product> products = query.getResultList();
        return products;
    }


}
