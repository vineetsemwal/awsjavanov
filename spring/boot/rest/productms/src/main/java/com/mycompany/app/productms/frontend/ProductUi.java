package com.mycompany.app.productms.frontend;

import com.mycompany.app.productms.entities.Product;
import com.mycompany.app.productms.exceptions.InvalidProductIdException;
import com.mycompany.app.productms.exceptions.InvalidProductNameException;
import com.mycompany.app.productms.exceptions.InvalidProductPriceException;
import com.mycompany.app.productms.services.IProductService;
import com.mycompany.app.productms.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductUi {

    @Autowired
    private IProductService service ;

    public void display(Product product) {
        System.out.println("product-" + product.getId() + "-" + product.getName() + "-" + product.getPrice());
    }

    public void start() {
        try {

            System.out.println("adding moto product");
            Product moto = service.addProduct("motorolla", 20000);
            long motoId = moto.getId();
            display(moto);

            System.out.println("adding samsung product");
            Product samsung = service.addProduct("samsung", 300000);
            long samsungId = samsung.getId();
            display(samsung);
            System.out.println("changing motorolla price");
            moto = service.changePrice(motoId, 25000);
            display(moto);

            System.out.println("samsung object to be fetched");
            samsung = service.findById(samsungId);
            display(samsung);


            System.out.println("find all products");
            List<Product> list= service.findAll();
            for(Product product:list){
                display(product);
            }


        } catch (InvalidProductIdException e) {
            System.out.println("id is invalid");
        } catch (InvalidProductNameException e) {
            System.out.println("product name is invalid");
        } catch (InvalidProductPriceException e) {
            System.out.println("product price is invalid");
        }
    }
}
