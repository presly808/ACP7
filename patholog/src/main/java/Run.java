import dao.DoctorDaoJpaImpl;
import service.DoctorService;
import service.DoctorServiceImpl;
import view.ConsoleMenu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class Run {


    public static void main(String[] args) throws IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-unit");
        DoctorService doctorService = new DoctorServiceImpl(new DoctorDaoJpaImpl(factory), null);
        //ProductService productService = null;

        ConsoleMenu consoleMenu = new ConsoleMenu(doctorService);
        consoleMenu.start();
    }
}
