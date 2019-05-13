package com.learn.jdbctransaction.runner;

import com.learn.jdbctransaction.model.Product;
import com.learn.jdbctransaction.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/*
 @Author Milan Paudyal
 @Date 5/13/19, Mon
*/

/**
 * The run method overrided in this class is automatically invoked when application starts
 * so that we don't need to make controller and to call the api
 */
@Component
public class ProductCommandRunner implements CommandLineRunner {

    private final ProductService productService;

    public ProductCommandRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> productList = Arrays.asList(new Product("Pen", 10L),
                new Product("Erase", 20L),
                new Product("Book", 200L),
                new Product("Copy", 5L));
        try {
            productService.saveProducts(productList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(productService.getProducts());
    }
}
