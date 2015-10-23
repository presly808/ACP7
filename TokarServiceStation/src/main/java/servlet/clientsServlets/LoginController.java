package servlet.clientsServlets;


import model.Client;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.ClientServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    private ClientServ clientServ;


    public void init() throws ServletException {

        ApplicationContext applicationContext =
                (ApplicationContext) getServletContext().getAttribute("spring-context");
        clientServ = applicationContext.getBean(ClientServ.class);


        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String driverLicenseNumber = req.getParameter("driverLicenseNumber");

        PrintWriter printWriter = resp.getWriter();

        req.getSession().setAttribute("email", email);
        req.getSession().setAttribute("pass", pass);
        req.getSession().setAttribute("driverLicenseNumber",
                driverLicenseNumber);







        //try{
        String accessToken = clientServ.login(email, pass, driverLicenseNumber);
        Client client = clientServ.getClient(accessToken);
        resp.addCookie(new Cookie("accessToken", accessToken));
        req.setAttribute("client", client);
        LOGGER.info("you are in system" + client.toString());
        req.getRequestDispatcher("/WEB-INF/pages/clientMenu.jsp").
                forward(req,resp);//}
      /*catch (WrongUserCredentionalException ex){
        LOGGER.error(ex.getMessage(), ex);
          req.getRequestDispatcher(ERROR_PAGE).forward(req,resp);

      }*/

        printWriter.flush();
    }
}
