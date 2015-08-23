package ua.artcode.week7.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Created by serhii on 22.08.15.
 */
public class TestCriteria {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-unit");
        EntityManager em = factory.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Robot> criteriaQuery = cb.createQuery(Robot.class);
    }
}
