package service;

import dao.ClientDao;
import dao.ClientDaoJPAImpl;
import dao.WorkerDao;
import exeption.NoClientFoundException;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import util.StringUtils;
import validation.Validator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 04.09.15.
 */

@Component
public class ClientServImpl implements ClientServ {

    private Map<String, Client> accessClientTokenMap = new ConcurrentHashMap<>();
    public static final int ACCESS_TOKEN_LENGHT = 12;

    @Autowired
    private ClientDaoJPAImpl clientDaoJPA;

    private WorkerDao workerDao;

    private Client client;


    private Validator<Client> clientValidator;


    public ClientServImpl() {
    }


    public ClientServImpl(Validator<Client> clientValidator, WorkerDao workerDao) {
        this.clientValidator = clientValidator;
        this.workerDao = workerDao;
    }

    @Override
    public Client register(String firstName, String secondName,
                           String phoneNumber, String email,
                           String driverLicenseNumber,String pass) {
        Client client = new Client(firstName,secondName,phoneNumber,
                email,driverLicenseNumber,pass);



        return clientDaoJPA.create(client);
    }

    @Override
    public String login(String email, String pass,String driverLicenseNumber) {

       //Client client;


        try {
            client = clientDaoJPA.findByDriverLicenseNumber(driverLicenseNumber);
        } catch (NoClientFoundException e) {
            e.printStackTrace();
        }

        if (!pass.equals(client.getPass())){
            System.out.println("wrong pass or email");
        }

        String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);


        accessClientTokenMap.put(accessToken,client);



        return accessToken;
    }

    @Override
    public Client update(String sessionToken, String firstName,
                         String secondName, String pass, String phoneNumber,
                         String driverLicenseNumber) {
        return null;
    }

    @Override
    public boolean delete(String sessionToken) {
        return false;
    }
}
