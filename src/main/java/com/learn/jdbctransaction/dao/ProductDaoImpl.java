package com.learn.jdbctransaction.dao;

import com.learn.jdbctransaction.constants.ProductQuery;
import com.learn.jdbctransaction.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 @Author Milan Paudyal
 @Date 5/13/19, Mon
*/

@Service
public class ProductDaoImpl implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveProducts(List<Product> products) {
        products.forEach(p -> {
            jdbcTemplate.update(ProductQuery.ADD_PRODUCTS, p.getName(), p.getPrice());
        });
    }

    @Override
    public List<Product> getProducts() {
        //if the variable of pojo class or entity class is matched to the database column
        //then we can use bean row mapper to map resultset to object
        //return jdbcTemplate.query(ProductQuery.GET_PRODUCTS, new BeanPropertyRowMapper<>(Product.class));
        return jdbcTemplate.query(ProductQuery.GET_PRODUCTS,
                (rs, count) -> new Product(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getDouble("Price")));
    }
}