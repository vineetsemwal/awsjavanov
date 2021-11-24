package com.mycompany.app.productms.daos;

import com.mycompany.app.productms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  IProductDao extends JpaRepository<Product,Long> {

    List<Product>findByPrice(double price);

    //only use in this way if products have unique names in the application
    Product findProductByName(String name);

    boolean existsByName(String name);

    @Query("from Product where price > :priceParam")
    List<Product>findProductsGreaterThanPrice(@Param("priceParam")double price);

}
