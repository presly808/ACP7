package dao;

import model.Patient;


import java.util.List;

/**
 * Created by serhii on 15.08.15.
 */
public interface PatientDao {

    // + id         -id
    Patient create(Patient patient);

    Patient update(Patient patient);

    boolean delete(Patient patient);

    List<Patient> findAll(Patient patient);

    Patient findById(long id);

    Patient findByKeyWord(String keyWord);

    // weak search, need filters (complex search request)

}
