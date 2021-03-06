package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.artcode.exception.NoUserException;
import ua.artcode.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Component("jpaUserDao")
public class UserDaoJpaImpl implements UserDao {

    @Autowired
    private EntityManagerFactory factory;

    public UserDaoJpaImpl() {
    }

    public UserDaoJpaImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public User create(User user) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try{
            transaction.begin();
            manager.persist(user);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }

        return user;
    }

    @Override
    public User update(User user) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();


        User found = findById(user.getId(), manager);

        if(found == null){
            return null;
        }

        found.setFullname(user.getFullname());
        found.setPass(user.getPass());
        found.setPhone(user.getPhone());

        try{
            transaction.begin();
            manager.merge(found);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }

        return found;
    }

    @Override
    public List<User> findAll() {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User findById(long id) throws NoUserException {
        EntityManager manager = factory.createEntityManager();
        return manager.find(User.class,id);
    }

    private User findById(long id, EntityManager manager){
        return manager.find(User.class,id);
    }

    @Override
    public User findByEmail(String email) throws NoUserException {
        // JPQL
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT u FROM User u WHERE u.email = :email");
        List<User> users = query.setParameter("email", email).getResultList();

        if(users == null || users.size() == 0){
            throw new NoUserException();
        }

        return users.get(0);
    }

    @Override
    public boolean delete(User user) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();


        User found = findById(user.getId(), manager);

        if(found == null){
            return false;
        }

        try{
            transaction.begin();
            manager.remove(found);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }

        return true;
    }
}
