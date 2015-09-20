package dao;

import exeption.NoServiceTypeFoundException;
import model.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by tokar on 20.09.2015.
 */
@Component("ServiceTypeJPA")
public class ServiceTypeDaoJPA implements ServiceTypeDao {
    @Autowired
    private EntityManagerFactory factory;

    public ServiceTypeDaoJPA() {
    }

    public ServiceTypeDaoJPA(EntityManagerFactory factory) {
        this.factory = factory;
    }


    @Override
    public ServiceType create(ServiceType service) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(service);
            transaction.commit();
            System.out.println("Service created");
        } catch (Exception e) {
            transaction.rollback();
        }


        return service;
    }

    @Override
    public ServiceType update(ServiceType service) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        ServiceType found = null;
        try {
            found = findById(service.getId());
            if (found == null) {
                return null;
            }

            found.setNameService(service.getNameService());
            found.setPriceOfService(service.getPriceOfService());
            found.setTimeToDo(service.getTimeToDo());
            found.setTypeOfService(service.getTypeOfService());

        } catch (NoServiceTypeFoundException e) {
            e.printStackTrace();
        }

        try {
            transaction.begin();
            manager.merge(found);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return null;
    }

    @Override
    public List<ServiceType> findAll() {
        EntityManager manager = factory.createEntityManager();
        javax.persistence.Query query = manager.createQuery("SELECT c FROM ServiceType c");

        List<ServiceType> cervices = query.getResultList();

        return cervices;

    }

    @Override
    public ServiceType findById(long id) throws NoServiceTypeFoundException {
        EntityManager manager = factory.createEntityManager();
        return manager.find(ServiceType.class, id);
    }

    @Override
    public boolean delete(ServiceType service) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        ServiceType found = null;

        try {
            found = findById(service.getId());

            if (found == null) {
                return false;
            }


        } catch (NoServiceTypeFoundException e) {
            e.printStackTrace();
        }

        try {
            transaction.begin();
            manager.remove(found);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return true;
    }
}
