package dao;

import exeption.NoServiceTypeFoundException;
import model.ServiceType;

import java.util.List;

/**
 * Created by tokar on 20.09.2015.
 */
public interface ServiceTypeDao {
    ServiceType create(ServiceType service);

    ServiceType update(ServiceType service);

    List<ServiceType> findAll();

    ServiceType findById(long id) throws NoServiceTypeFoundException;

    boolean delete(ServiceType service);

   }
