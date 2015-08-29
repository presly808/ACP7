package ua.artcode.ClassWork.Week_7.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by serhii on 22.08.15.
 */
public class InitEntityManagerFactory {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-unit");
    }
}
