package ua.artcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.dao.UserDao;
import ua.artcode.dao.UserDaoJDBCImp;
import ua.artcode.dao.UserDaoJpaImpl;
import ua.artcode.model.Product;
import ua.artcode.model.User;
import ua.artcode.service.ProductService;
import ua.artcode.service.UserService;
import ua.artcode.service.UserServiceImpl;
import ua.artcode.view.ConsoleMenu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.applet.AppletContext;
import java.util.Arrays;

/**
 * Created by serhii on 15.08.15.
 */
public class Run{


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");


        System.out.println("Beans count " + context.getBeanDefinitionCount());
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        ConsoleMenu consoleMenu = context.getBean(ConsoleMenu.class);

        //ConsoleMenu c2 = new ConsoleMenu();

        consoleMenu.start();
    }
}
