import dao.UserDaoJpaImpl;
import service.UserService;
import service.UserServiceImpl;
import view.ConsoleMenu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {


    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-unit");
        UserService userService = new UserServiceImpl(new UserDaoJpaImpl(factory), null);
        //ProductService productService = null;

        ConsoleMenu consoleMenu = new ConsoleMenu(userService);
        consoleMenu.start();
    }
}
