package service;

import exception.ValidationException;
import exception.WrongUserCredentialException;
import model.Doctor;


public interface DoctorService {

    Doctor register(String fullname, String rank, String email, String phone,
                    String login, String pass) throws ValidationException;

    String login(String login, String pass) throws WrongUserCredentialException;

    Doctor update(String sessionToken, String fullname, String login,
                  String pass, String email, String rank, String phone);

    boolean delete(String sessionToken);


}
