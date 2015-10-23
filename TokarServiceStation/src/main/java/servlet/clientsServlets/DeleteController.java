package servlet.clientsServlets;

import model.Client;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.ClientServ;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/deleter"})
public class DeleteController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(
            LoginController.class);
    private ClientServ clientServ;
    private LoginController loginController;
    Client client;


    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext =
                (ApplicationContext) getServletContext().
                        getAttribute("spring-context");
        clientServ = applicationContext.getBean(ClientServ.class);
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

       String pass = (String) req.getSession().getAttribute("pass");
       String email = (String) req.getSession().getAttribute("email");
       String driverLicenseNumber = (String) req.getSession().
               getAttribute("driverLicenseNumber");

       /*Client cl = (Client) req.getSession().getAttribute("client");
       long newIdd =  cl.getId();*/
        //String newId = req.getParameter("id");
       // long newIdd = Long.parseLong(newId);
        //String email = req.getParameter("email");
        //String driverLicenseNumber = req.getParameter("driverLicenseNumber");
        //String pass = req.getParameter("pass");


        String accessToken = clientServ.login(email, pass,
                driverLicenseNumber);


        clientServ.delete(email,pass,driverLicenseNumber);

        System.out.println("delete info from deleter servlet");

        req.getRequestDispatcher("/index.html").
                forward(req, resp);
        printWriter.flush();





    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Get request in deleter");

        req.getRequestDispatcher("/WEB-INF/pages/deleter.jsp").forward(req, resp);
    }
}
