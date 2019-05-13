package com.learn.jdbctransaction.dao;

/*
 @Author Milan Paudyal
 @Date 5/13/19, Mon
*/

import com.learn.jdbctransaction.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private ProductDao productDao;

    @Before
    public void setUp() {
        productDao = new ProductDaoImpl(jdbcTemplate);
    }

    @Test
    public void testSaveProducts() {
        productDao.saveProducts(getProducts());
        Mockito.verify(jdbcTemplate, Mockito.times(5))
                .update(Matchers.anyString(), Matchers.anyString(), Matchers.anyDouble());
    }

    @Test
    public void testGetProducts(){
      Mockito.when(jdbcTemplate.query(Matchers.anyString(), Matchers.any(RowMapper.class)))
        .thenReturn(getProducts());
        Assert.assertEquals(productDao.getProducts().size(), getProducts().size());
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
