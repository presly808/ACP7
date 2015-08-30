package ua.artcode.service;


import ua.artcode.exception.ValidationException;
import ua.artcode.exception.WrongUserCredentialException;
import ua.artcode.model.User;

/*
*
* */
public interface UserService {

    User register(String fullname, String phone,
                  String email, String pass) throws ValidationException;

    String login(String email, String pass) throws WrongUserCredentialException;

    User update(String sessionToken, String fullname, String pass, String phone);

    boolean delete(String sessionToken);


}
