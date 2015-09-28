package service;

import dao.ClientDao;
import dao.ClientDaoJPAImpl;
import dao.WorkerDao;
import exeption.NoClientFoundException;
import model.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import util.StringUtils;
import validation.Validator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ClientServImpl implements ClientServ {

    private static final Logger LOGGER = Logger.getLogger(ClientServImpl.class);

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

        String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);


        accessClientTokenMap.put(accessToken,client);



        return clientDaoJPA.create(client);
    }

    @Override
    public String login(String email, String pass,String driverLicenseNumber) {

        try {
            client = clientDaoJPA.findByEmail(email);
        } catch (NoClientFoundException e) {
            e.printStackTrace();
        }

        if (!pass.equals(client.getPass())&&
                !driverLicenseNumber.equals(client.getDriverLicenseNumber())){
            System.out.println("wrong pass,email or driverlicense number!!!");
        }

        String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);


        accessClientTokenMap.put(accessToken,client);



        return accessToken;
    }

    @Override
    public Client update(String phoneNumber, String email,
                         String driverLicenseNumber,String pass) {
        /*Client updateClient  = new Client(firstName,secondName,phoneNumber,
                email,driverLicenseNumber,pass);*/

/*

        try {
            clientDaoJPA.findByEmail(email);

        } catch (NoClientFoundException e) {
            e.printStackTrace();
        }

        */
       String accessToken =login(email, pass, driverLicenseNumber);

       Client client = accessClientTokenMap.get(accessToken);

       long id = client.getId();



        clientDaoJPA.update(email,pass,driverLicenseNumber,
                phoneNumber,id);

        return client;
    }

    @Override
    public boolean delete(String email, String pass,String driverLicenseNumber,long id) {


        String accessToken =login(email, pass, driverLicenseNumber);

        Client client = accessClientTokenMap.get(accessToken);

       // long id = client.getId();



        clientDaoJPA.delete(client);
        System.out.println("client deleted (info from clientServ)!!!");


        return true;
    }

    @Override
    public Client getClient(String accessToken) {

        return accessClientTokenMap.get(accessToken);

    }

    @Override
    public Client getClient(long id) {
        Client found = null;

        try {
            clientDaoJPA.findById(id);
        } catch (NoClientFoundException e) {
            e.printStackTrace();
        }

        return found;
    }
}
