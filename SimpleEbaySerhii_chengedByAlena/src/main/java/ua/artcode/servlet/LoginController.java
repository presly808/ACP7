package ua.artcode.servlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.exception.WrongUserCredentialException;
import ua.artcode.model.User;
import ua.artcode.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(LoginController.class);
    public static final String PATH = "/WEB-INF/pages/user-info-jstl.jsp";
    public static final String ERROR_PAGE = "/WEB-INF/pages/error.jsp";
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext app = (ApplicationContext) getServletContext().getAttribute("spring-context");
        userService = app.getBean(UserService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        PrintWriter pw = resp.getWriter();
        try {
            String accessToken = userService.login(email,pass);
            User user = userService.getUser(accessToken);
            resp.addCookie(new Cookie("accessToken", accessToken));
            LOG.info("User in system " + user.toString());

            req.setAttribute("user", user);


            req.getRequestDispatcher(PATH).forward(req,resp);

        } catch (WrongUserCredentialException e) {
            LOG.error(e.getMessage(), e);
            req.setAttribute("ex",e);
            req.getRequestDispatcher(ERROR_PAGE).forward(req,resp);
        }

        pw.flush();

    }
}
