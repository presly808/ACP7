package dao;


import exception.NoUserException;
import model.User;

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
