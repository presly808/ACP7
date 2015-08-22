import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Legion on 22.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-unit");
    }
}
