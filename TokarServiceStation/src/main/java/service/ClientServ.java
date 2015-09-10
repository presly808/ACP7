package service;

import model.Client;

public interface ClientServ {

    Client register (String firstName, String secondName,String phoneNumber,
                     String email, String driverLicenseNumber,String pass);

    String login (String email, String pass, String driverLicenseNumber);

    Client update(String sessionToken, String firstName, String secondName,
                String pass,String phoneNumber, String driverLicenseNumber);

    boolean delete(String sessionToken);


    Client getClient (String accessToken);

    Client getClient (long id);



}
