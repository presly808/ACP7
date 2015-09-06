package dao;


import exception.NoUserException;
import model.Doctor;

import java.util.List;

//CRUD + other
public interface DoctorDao {

    Doctor create(Doctor doctor);

    Doctor update(Doctor doctor);

    List<Doctor> findAll();

    Doctor findById(long id) throws NoUserException;

    Doctor findByEmail(String email) throws NoUserException;

    boolean delete(Doctor doctor);

}
