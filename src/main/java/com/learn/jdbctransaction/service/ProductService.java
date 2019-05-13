package com.learn.jdbctransaction.service;

import com.learn.jdbctransaction.model.Product;

import java.util.List;

/*
 @Author Milan Paudyal
 @Date 5/13/19, Mon
*/
public interface ProductService {
    void saveProducts(List<Product> products);

    List<Product> getProducts();
}
