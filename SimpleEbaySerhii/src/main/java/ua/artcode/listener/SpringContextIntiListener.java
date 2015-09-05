package ua.artcode.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringContextIntiListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context init");
        ApplicationContext app = new ClassPathXmlApplicationContext("app-context.xml");
        sce.getServletContext().setAttribute("spring-context", app);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
