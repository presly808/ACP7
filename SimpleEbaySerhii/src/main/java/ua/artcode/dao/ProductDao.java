package ua.artcode.dao;

import ua.artcode.model.Product;

import java.util.List;

/**
 * Created by serhii on 15.08.15.
 */
public interface ProductDao {

    // + id         -id
    Product create(Product product);

    Product update(Product product);

    boolean delete(Product product);

    List<Product> findAll(Product product);

    Product findById(long id);

    Product findByKeyWord(String keyWord);

    // weak search, need filters (complex search request)

}
