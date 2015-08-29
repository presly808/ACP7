package ua.artcode.service;


import ua.artcode.model.Product;

import java.util.List;

public interface ProductService {

    // how to link product with user, where user info?
    Product addNewProduct(String sessionToken, String title, String description, double price);

    Product update(String sessionToken, long productId,String title, String description, double price);

    List<Product> getAll();

    List<Product> findProduct(String keyWord);

    List<Product> getUserProducts(long userId);

    boolean deleteProduct(String sessionToken, long productId);



}
