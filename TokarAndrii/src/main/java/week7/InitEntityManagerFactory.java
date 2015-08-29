package week7;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InitEntityManagerFactory {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-unit");
    }
}
