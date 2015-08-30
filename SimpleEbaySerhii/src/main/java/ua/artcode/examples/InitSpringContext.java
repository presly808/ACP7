package ua.artcode.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.dao.UserDao;
import ua.artcode.exception.NoUserException;
import ua.artcode.model.Product;
import ua.artcode.model.User;

import java.util.List;

/**
 * Created by serhii on 29.08.15.
 */
public class InitSpringContext {

    public static void main(String[] args) throws NoUserException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("app-context.xml");

        User user = (User) applicationContext.getBean("user");

        User user3 = (User) applicationContext.getBean("user");

        Product product = applicationContext.getBean("product", Product.class);

        UserDao dao = applicationContext.getBean(UserDao.class);

        dao.create(user);


        System.out.println(user);
        //System.out.println(user2);


    }
}
