package com.learn.jdbctransaction.constants;

/*
 @Author Milan Paudyal
 @Date 5/13/19, Mon
*/
public interface ProductQuery {
    final String ADD_PRODUCTS = "insert into Product(Name, Price) values(?, ?)";
    final String GET_PRODUCTS = "select Id, Name, Price from Product";
}