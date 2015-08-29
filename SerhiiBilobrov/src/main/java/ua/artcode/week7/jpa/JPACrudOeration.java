package ua.artcode.week7.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by serhii on 23.08.15.
 */
public class JPACrudOeration {

    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-unit");
        EntityManager entityManager = factory.createEntityManager();

        Robot robot = new Robot("R2D2", 2000, new Date(), RobotType.ANDROID);


        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(robot);// add to context, buff
            transaction.commit(); // flush buffer to db
        } catch (Exception e){
            transaction.rollback();
        }

        Robot robot1 = find(1, entityManager);

        remove(1,entityManager);
        System.out.println(robot1);


        Robot robot2 = new Robot();
        robot2.setId(2);
        robot2.setModel("UPDATED");
        robot2.setPrice(10000);
        robot2.setRobotType(RobotType.BPLA);

        update(robot2, entityManager);


    }

    public static Robot find(long id, EntityManager entityManager){
        Robot found = entityManager.find(Robot.class, id);
        return found;
    }


    public static void update(Robot robot, EntityManager entityManager){
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.merge(robot);
            transaction.commit(); // flush buffer to db
        } catch (Exception e){
            transaction.rollback();
        }
    }

    public static void remove(long id, EntityManager entityManager){
        Robot robot = find(id,entityManager);

        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.remove(robot);
            transaction.commit(); // flush buffer to db
        } catch (Exception e){
            transaction.rollback();
        }
    }
}
