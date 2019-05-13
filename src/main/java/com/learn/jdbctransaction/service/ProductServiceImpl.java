package com.learn.jdbctransaction.service;

import com.learn.jdbctransaction.dao.ProductDao;
import com.learn.jdbctransaction.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 @Author Milan Paudyal
 @Date 5/13/19, Mon
*/

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * since this method is annotated as transaction so either all the provided
     * products will be stored in database or no data will be stored because if
     * one if one updation failed then the products that are updated already will
     * be rolled backed automatically because of the ACID property
     *
     * @param products list of products
     */
    @Override
    @Transactional
    public void saveProducts(List<Product> products) {
        System.out.println("Saving products to database");
        productDao.saveProducts(products);
    }

    @Override
    public List<Product> getProducts() {
        System.out.println("Fetching product details");
        return productDao.getProducts();
    }
}
