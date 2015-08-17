package ua.artcode.ClassWork.Week_5.SimpleEbay.dao;

import ua.artcode.ClassWork.Week_5.SimpleEbay.exception.NoUserException;
import ua.artcode.ClassWork.Week_5.SimpleEbay.model.User;
import java.util.List;

//CRUD + other
public interface UserDao {

    User create(User user);

    User update(User user);

    List<User> findAll();

    User findById(long id) throws NoUserException;

    User findByEmail(String email) throws NoUserException;

    boolean delete(User user);

}
