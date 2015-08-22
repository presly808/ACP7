package ua.artcode.week7;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by pikolo on 22.08.15.
 */
public class InitEntityManagerFactory {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-unit");
    }
}
