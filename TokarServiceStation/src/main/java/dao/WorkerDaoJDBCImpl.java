package dao;

import exeption.NoClientFoundException;
import model.Worker;

import java.util.List;

/**
 * Created by root on 04.09.15.
 */
public class WorkerDaoJDBCImpl implements WorkerDao {
    @Override
    public Worker create(Worker worker) {
        return null;
    }

    @Override
    public Worker update(Worker worker) {
        return null;
    }

    @Override
    public List<Worker> findAll() {
        return null;
    }

    @Override
    public Worker findById(long id) throws NoClientFoundException {
        return null;
    }

    @Override
    public Worker findByDriverLicenseNumber(String driverLicenseNumber) throws NoClientFoundException {
        return null;
    }

    @Override
    public boolean delete(Worker worker) {
        return false;
    }
}
