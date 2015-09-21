package dao;

import com.mysql.jdbc.Connection;
import exeption.NoClientFoundException;
import model.Client;

import java.util.List;

/**
 * Created by tokar on 01.09.2015.
 */
public class ClientDaoJDBC implements ClientDao {
    @Override
    public Client create(Client client) {

        return null;
    }

    @Override
    public Client update(String email,String pass, String driverLicenseNumber,
                         String phoneNumber, long id) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Client findById(long id) throws NoClientFoundException {
        return null;
    }

    @Override
    public Client  findByDriverLicenseNumber(String driverLicenseNumber) throws NoClientFoundException {
        return null;
    }

    @Override
    public boolean delete(Client client) {
        return false;
    }

    @Override
    public Client findByEmail(String email) throws NoClientFoundException {
        return null;
    }
}
