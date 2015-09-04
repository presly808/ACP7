package dao;



import exception.NoUserException;
import model.Doctor;
import util.ConnectionFactory;

import java.sql.*;
import java.util.List;

public class DoctorDaoJDBCImp implements DoctorDao {
    @Override
    public Doctor create(Doctor doctor) {

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String sqlRequest = String.format(
                    "INSERT INTO doctors(fullname,email,pass,phone) VALUES ('%s','%s','%s','%s')",
                    doctor.getFullName(), doctor.getEmail(), doctor.getPass(), doctor.getPhone());
            statement.executeUpdate(sqlRequest);

            return findByEmail(doctor.getEmail());

        } catch (SQLException | NoUserException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Doctor update(Doctor doctor) {
        return null;
    }

    @Override
    public List<Doctor> findAll() {
        return null;
    }

    @Override
    public Doctor findById(long id) throws NoUserException {
        return null;
    }

    @Override
    public Doctor findByEmail(String email) throws NoUserException {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id,fullname,email,phone,pass FROM users WHERE email=?")) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if(!rs.next()){
                throw new NoUserException();
            }

            //convert ResultSet to user
            Doctor doctor = new Doctor();
           // user.setId(rs.getInt("id"));
            doctor.setEmail(rs.getString("email"));
            doctor.setPhone(rs.getString("phone"));
            doctor.setFullName(rs.getString("fullname"));
            doctor.setPass(rs.getString("pass"));

            return doctor;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(Doctor doctor) {
        return false;
    }
}
