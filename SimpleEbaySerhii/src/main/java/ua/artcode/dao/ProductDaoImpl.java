package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.artcode.model.Product;
import ua.artcode.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private EntityManagerFactory factory;

    public ProductDaoImpl() {
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Product create(Product product) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try{

            User fixedInContext = manager.find(User.class, product.getOwner().getId());
            product.setOwner(fixedInContext);

            transaction.begin();
            manager.persist(product);
            transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public boolean delete(Product product) {
        return false;
    }

    @Override
    public List<Product> findAll(Product product) {
        return null;
    }

    @Override
    public Product findById(long id) {
        EntityManager manager = factory.createEntityManager();
        return manager.find(Product.class, id);
    }

    @Override
    public Product findByKeyWord(String keyWord) {
        return null;
    }
}
