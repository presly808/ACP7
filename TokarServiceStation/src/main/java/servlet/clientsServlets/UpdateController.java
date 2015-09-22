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

// this servlet processes only post request, not get
@WebServlet(urlPatterns = {"/updater"})
public class UpdateController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    private ClientServ clientServ;
    private LoginController loginController;


    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext =
                (ApplicationContext) getServletContext().getAttribute("spring-context");
        clientServ = applicationContext.getBean(ClientServ.class);
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       /* String email = req.getParameter("email");
        String driverLicenseNumber = req.getParameter("driverLicenseNumber");
        String pass = req.getParameter("pass");
*/
        // why do you need this code
        PrintWriter printWriter = resp.getWriter();
        //printWriter.flush();


        //String accessToken = clientServ.login(email, pass, driverLicenseNumber);

        String newphoneNumber = req.getParameter("phoneNumber");
        String newemail = req.getParameter("email");
        String newdriverLicenseNumber = req.getParameter("driverLicenseNumber");
        String newpass = req.getParameter("pass");
        String accessToken = clientServ.login(newemail,newpass,
                newdriverLicenseNumber);

        Client client = clientServ.update(newphoneNumber, newemail,
                newdriverLicenseNumber, newpass);
        resp.addCookie(new Cookie("accessToken", accessToken));
        req.setAttribute("client", client);
        System.out.println("update your information");
        LOGGER.info("update your information" + client.toString());
        req.getRequestDispatcher("/WEB-INF/pages/clientMenu.jsp").
                forward(req, resp);
        printWriter.flush();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get request in updater");
        // Can do any actions before forwarding

        req.getRequestDispatcher("/WEB-INF/pages/updater.jsp").forward(req,resp);
    }
}
