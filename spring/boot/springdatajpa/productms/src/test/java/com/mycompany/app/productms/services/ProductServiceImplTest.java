package com.mycompany.app.productms.services;

import com.mycompany.app.productms.dtos.AddProductRequest;
import com.mycompany.app.productms.dtos.ProductDetails;
import com.mycompany.app.productms.entities.Product;
import com.mycompany.app.productms.exceptions.InvalidProductNameException;
import com.mycompany.app.productms.exceptions.ProductNotFoundException;
import com.mycompany.app.productms.util.ProductUtil;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Import({ProductServiceImpl.class, ProductUtil.class})
@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ProductServiceImplTest {

    @Autowired
    private IProductService productService;

    @Autowired
    private EntityManager em;

    /**
     * scenario : product successfully added
     */
    @Test
    public void testAddProduct_1(){
        String name="samsung";
        double price=100;
        AddProductRequest request=new AddProductRequest();
        request.setPrice(price);
        request.setName(name);
        ProductDetails result=productService.addProduct(request);
        assertEquals(name,result.getProductName());
        assertEquals(price,result.getPrice());

       TypedQuery<Product>query =em.createQuery("from Product",Product.class);
       List<Product> storedProducts =query.getResultList();
       assertEquals(1,storedProducts.size());
       Product storedProduct=storedProducts.get(0);
       assertEquals(name,storedProduct.getName());
       assertEquals(price,storedProduct.getPrice());

    }

    /**
     * scenaio : product successfully fetched from store
     * precondition : product exists in store
     */
    @Test
    public void testFindProductDetailsById_1(){
        String name="samsung";
        double price=200;
        Product product=new Product();
        product.setPrice(price);
        product.setName(name);
        em.persist(product);
        long productId=product.getId();

        ProductDetails result=productService.findProductDetailsById(productId);
        assertEquals(200,result.getPrice());
        assertEquals(name,result.getProductName());
        assertEquals(price,result.getPrice());
        assertEquals(productId,result.getId());


    }

    /**
     * scenaio : product NOT successfully fetched from store
     * precondition : product does NOT exist in store
     * expectation: ProductNotFoundException is thrown
     */
    @Test
    public void testFindProductDetailsById_2(){
        long productId=67476;
        /*
        Executable executable=new Executable(){
            @Override
            public void execute() throws Throwable {
                productService.findProductDetailsById(productId);

            }
        } ;
*/
        Executable executable=()->productService.findProductDetailsById(productId);
        assertThrows(ProductNotFoundException.class,executable);

    }

}
