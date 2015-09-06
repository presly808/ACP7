package dao;

import exeption.NoClientFoundException;
import model.Worker;

import java.util.List;

/**
 * Created by root on 04.09.15.
 */
public interface WorkerDao {


    Worker create(Worker worker);

    Worker update(Worker worker);

    List<Worker> findAll();

    Worker findById(long id) throws NoClientFoundException;

    Worker findByDriverLicenseNumber(String driverLicenseNumber)
            throws NoClientFoundException;

    boolean delete(Worker worker);



}
