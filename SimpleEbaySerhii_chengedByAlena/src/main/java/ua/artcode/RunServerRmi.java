package ua.artcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by serhii on 30.08.15.
 */
public class RunServerRmi {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("rmi-server-context.xml");
    }
}
