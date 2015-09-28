package service;

import model.Client;

public interface ClientServ {

    Client register (String firstName, String secondName,String phoneNumber,
                     String email, String driverLicenseNumber,String pass);

    String login (String email, String pass, String driverLicenseNumber);

    Client update(String phoneNumber, String email,
                  String driverLicenseNumber,String pass);

    boolean delete(String email, String pass,String driverLicenseNumber,long id);


    Client getClient (String accessToken);

    Client getClient (long id);



}
