package ua.artcode.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.exception.WrongUserCredentialException;
import ua.artcode.model.User;
import ua.artcode.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext app = (ApplicationContext) req.getServletContext().getAttribute("spring-context");
        UserService userService = app.getBean(UserService.class);

        String email = req.getParameter("email");
        String pass = req.getParameter("pass");


        PrintWriter pw = resp.getWriter();
        try {
            String accessToken = userService.login(email,pass);
            pw.println("Your access token is " + accessToken);
        } catch (WrongUserCredentialException e) {
            e.printStackTrace();
            pw.println(e.getMessage());
        }

        pw.flush();

    }
}
