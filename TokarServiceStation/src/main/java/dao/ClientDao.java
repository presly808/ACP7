package dao;

import exeption.NoClientFoundException;
import model.Client;

import java.util.List;

/**
 * Created by tokar on 01.09.2015.
 */
public interface ClientDao {

    Client create(Client client);

    Client update(Client client);

    List<Client> findAll();

    Client findById(long id) throws NoClientFoundException;

    Client findByDriverLicenseNumber(String driverLicenseNumber) throws NoClientFoundException;

    boolean delete(Client client);

    Client findByEmail (String email) throws NoClientFoundException;
}
