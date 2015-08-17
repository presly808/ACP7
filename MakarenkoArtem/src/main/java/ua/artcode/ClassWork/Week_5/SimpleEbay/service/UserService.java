package ua.artcode.ClassWork.Week_5.SimpleEbay.service;


import ua.artcode.ClassWork.Week_5.SimpleEbay.exception.ValidationException;
import ua.artcode.ClassWork.Week_5.SimpleEbay.exception.WrongUserCredentialException;
import ua.artcode.ClassWork.Week_5.SimpleEbay.model.User;

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
