package ua.artcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.artcode.dao.ProductDao;
import ua.artcode.model.Product;
import ua.artcode.model.User;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserService userService;

    public ProductServiceImpl() {
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product addNewProduct(String sessionToken, String title, String description, double price) {

        User user = userService.getUser(sessionToken);
        Product product = new Product(price,title,description);
        product.setOwner(user);

        return productDao.create(product);
    }

    @Override
    public Product update(String sessionToken, long productId, String title, String description, double price) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> findProduct(String keyWord) {
        return null;
    }

    @Override
    public List<Product> getUserProducts(long userId) {
        return null;
    }

    @Override
    public boolean deleteProduct(String sessionToken, long productId) {
        return false;
    }
}
