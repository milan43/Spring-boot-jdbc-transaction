package com.learn.jdbctransaction.service;

import com.learn.jdbctransaction.dao.ProductDao;
import com.learn.jdbctransaction.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/*
 @Author Milan Paudyal
 @Date 5/14/19, Tue
*/

public class ProductServiceImplTest {

    @Mock
    private ProductDao productDao;

    private ProductService productService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productDao);
        Mockito.when(productDao.getProducts())
                .thenReturn(getProducts());
        Mockito.doNothing().when(productDao)
                .saveProducts(Matchers.anyList());
    }

    @Test
    public void testSaveProducts() {
        List<Product> productList = getProducts();
        productService.saveProducts(productList);
        Mockito.verify(productDao, Mockito.times(1))
                .saveProducts(productList);
    }

    @Test
    public void testGetProducts() {
        List<Product> expectedList = getProducts();
        List<Product> resultList = productService.getProducts();
        Assert.assertEquals(expectedList.get(0).getName(), resultList.get(0).getName());
    }


    private List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Product p = new Product();
            p.setId(i);
            p.setName("p" + i);
            p.setPrice(10 * i);
            productList.add(p);
        }
        return productList;
    }
}