package ua.artcode.dao;

import ua.artcode.exception.NoUserException;
import ua.artcode.model.User;
import ua.artcode.util.ConnectionFactory;

import java.sql.*;
import java.util.List;

/**
 * Created by serhii on 15.08.15.
 */
public class UserDaoJDBCImp implements UserDao {
    @Override
    public User create(User user) {

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String sqlRequest = String.format(
                    "INSERT INTO users(fullname,email,pass,phone) VALUES ('%s','%s','%s','%s')",
                    user.getFullname(), user.getEmail(), user.getPass(), user.getPhone());
            statement.executeUpdate(sqlRequest);

            return findByEmail(user.getEmail());

        } catch (SQLException | NoUserException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(long id) throws NoUserException {
        return null;
    }

    @Override
    public User findByEmail(String email) throws NoUserException {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id,fullname,email,phone,pass FROM users WHERE email=?")) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if(!rs.next()){
                throw new NoUserException();
            }

            //convert ResultSet to user
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setFullname(rs.getString("fullname"));
            user.setPass(rs.getString("pass"));

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }
}
