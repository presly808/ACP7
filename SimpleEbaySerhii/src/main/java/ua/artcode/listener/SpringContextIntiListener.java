package ua.artcode.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashSet;

public class SpringContextIntiListener implements ServletContextListener {

    //public static String APP_NAME = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context init");
        ServletContext servletContext = sce.getServletContext();
        String springLocation = servletContext.getInitParameter("spring-context-location");
        ApplicationContext app = new ClassPathXmlApplicationContext(springLocation);
        servletContext.setAttribute("spring-context", app);


        String appName = servletContext.getInitParameter("app-url");

        servletContext.setAttribute("APP_NAME", appName);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
