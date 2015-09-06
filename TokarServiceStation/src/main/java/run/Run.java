package run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.ConsoleMenu;

import java.applet.AppletContext;

/**
 * Created by root on 05.09.15.
 */
public class Run {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("app-context.xml");


        ConsoleMenu consoleMenu = applicationContext.getBean(ConsoleMenu.class);
    }
}
