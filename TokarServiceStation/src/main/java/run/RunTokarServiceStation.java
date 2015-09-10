package run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.ConsoleMenu;

import java.applet.AppletContext;

public class RunTokarServiceStation {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("app-context.xml");


        ConsoleMenu consoleMenu = applicationContext.getBean(ConsoleMenu.class);
        consoleMenu.start();
    }
}
