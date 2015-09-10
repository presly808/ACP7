package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by root on 10.09.15.
 */
public class SpringContextInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String spingLocation = servletContext.getInitParameter("spring-context-location");
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(spingLocation);
        servletContext.setAttribute("spring-context",applicationContext);


        String appName = servletContext.getInitParameter("app-url");

        servletContext.setAttribute("APP_NAME", appName);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
