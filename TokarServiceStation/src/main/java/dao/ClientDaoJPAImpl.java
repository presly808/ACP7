package dao;

import exeption.NoClientFoundException;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Component("jpaClientDaoJPA")
public class ClientDaoJPAImpl implements ClientDao {
    @Autowired
    private EntityManagerFactory factory;

    public ClientDaoJPAImpl() {
    }


    public ClientDaoJPAImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }


    @Override
    public Client create(Client client) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {

            transaction.begin();
            manager.persist(client);
            transaction.commit();
            System.out.println("client made!!!!");
        } catch (Exception e) {
            transaction.rollback();
        }


        return client;
    }

    @Override
    public Client update(String email,String pass, String driverLicenseNumber,
                         String phoneNumber, long id) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Client found = null;


        try {
            found = findById(id);
            if (found == null) {
                return null;
            }

            found.setDriverLicenseNumber(driverLicenseNumber);
            found.setEmail(email);
            found.setPhoneNumber(phoneNumber);
            /*found.setFirstName(client.getFirstName());
            found.setSecondtName(client.getSecondName());*/
            found.setPass(pass);

        } catch (NoClientFoundException e) {
            e.printStackTrace();
        }


        try {
            transaction.begin();
            manager.merge(found);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        return found;
    }

    @Override
    public List<Client> findAll() {
        EntityManager manager = factory.createEntityManager();
        javax.persistence.Query query = manager.createQuery("SELECT c FROM Client c");

        List<Client> clients = query.getResultList();

        return clients;
    }

    @Override
    public Client findById(long id) throws NoClientFoundException {
        EntityManager manager = factory.createEntityManager();

        return manager.find(Client.class, id);
    }

    @Override
    public Client findByDriverLicenseNumber(String driverLicenseNumber) throws NoClientFoundException {
        EntityManager manager = factory.createEntityManager();
        return manager.find(Client.class, driverLicenseNumber);

    }

    @Override
    public Client findByEmail(String email) throws NoClientFoundException {

        EntityManager manager = factory.createEntityManager();
        javax.persistence.Query query = manager.createQuery("SELECT u FROM Client u WHERE u.email = :email");
        List<Client> clients = query.setParameter("email", email).getResultList();
        if (clients == null || clients.size() == 0) {
            System.out.println("no client found");
        }

        return clients.get(0);

    }

    @Override
    public boolean delete(Client client) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        Client found = null;

        try {
            found = findById(client.getId());

            if (found == null) {
                return false;
            }


        } catch (NoClientFoundException e) {
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
