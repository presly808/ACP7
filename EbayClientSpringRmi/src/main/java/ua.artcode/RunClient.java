package ua.artcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.view.ConsoleMenu;

/**
 * Created by serhii on 30.08.15.
 */
public class RunClient {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("client-rmi-context.xml");
        ConsoleMenu menu = ac.getBean(ConsoleMenu.class);

        menu.start();
    }
}
