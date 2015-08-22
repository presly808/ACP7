package ua.artcode.ClassWork.Week_7.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Created by HOME on 22.08.2015.
 */
public class InitEntityManagerFactory {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-unit");
    }


}
