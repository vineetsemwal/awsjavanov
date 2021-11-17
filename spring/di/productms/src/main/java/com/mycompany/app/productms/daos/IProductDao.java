package com.mycompany.app.productms.daos;

import com.mycompany.app.productms.entities.Product;

public interface  IProductDao {

    Product save(Product product);

    Product findById(long id);


}
