package ua.artcode;

import javax.persistence.Persistence;

/**
 * Created by serhii on 23.08.15.
 */
public class InitJpaFactory {

    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("my-unit");
    }
}