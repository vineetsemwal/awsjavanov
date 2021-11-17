package com.mycompany.app.productms.daos;

import com.mycompany.app.productms.entities.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class ProductDaoImpl implements IProductDao{

    private Map<Long,Product> store=new HashMap<>();

    @Override
    public Product save(Product product) {
      store.put(product.getId(),product);
      return product;
    }

    @Override
    public Product findById(long id) {
        Product product=store.get(id);
        return product;
    }
}
