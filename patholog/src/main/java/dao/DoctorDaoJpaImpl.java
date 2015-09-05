package dao;



import exception.NoUserException;
import model.Doctor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by serhii on 23.08.15.
 */
public class DoctorDaoJpaImpl implements DoctorDao {

    private EntityManagerFactory factory;

    public DoctorDaoJpaImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Doctor create(Doctor doctor) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try{
            transaction.begin();
            manager.persist(doctor);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }

        return doctor;
    }

   @Override
   public Doctor update(Doctor doctor) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();


       Doctor found = findById(doctor.getId(), manager);

        if(found == null){
            return null;
        }

        found.setFullName(doctor.getFullName());
        found.setPass(doctor.getPass());
        found.setPhone(doctor.getPhone());

        try{
            transaction.begin();
            manager.merge(found);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }

        return null;
    }

    @Override
    public List<Doctor> findAll() {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT u FROM Doctor u");
        List<Doctor> doctors = query.getResultList();

        return doctors;
    }

    @Override
    public Doctor findById(long id) throws NoUserException {
        EntityManager manager = factory.createEntityManager();
        return manager.find(Doctor.class,id);
    }

    private Doctor findById(long id, EntityManager manager){
        return manager.find(Doctor.class,id);
    }

    @Override
    public Doctor findByEmail(String email) throws NoUserException {
        // JPQL
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT u FROM Doctor u WHERE u.email = :email");
        Doctor doctor = (Doctor) query.setParameter("email", email).getSingleResult();

        return doctor;
    }

   @Override
    public boolean delete(Doctor doctor) {
       /*  EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();


        User found = findById(user.getId(), manager);

        if(found == null){
            return false;
        }



        try{
            transaction.begin();
            manager.remove(found);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }
*/
        return true;
    }
}
