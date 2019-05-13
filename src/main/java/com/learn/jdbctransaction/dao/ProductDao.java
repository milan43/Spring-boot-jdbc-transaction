package com.learn.jdbctransaction.dao;

import com.learn.jdbctransaction.model.Product;

import java.util.List;

/*
 @Author Milan Paudyal
 @Date 5/13/19, Mon
*/
public interface ProductDao {
    void saveProducts(List<Product> products);

    List<Product> getProducts();
}
