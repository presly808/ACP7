package servlet.clientsServlets;

import model.Client;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.ClientServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    private ClientServ clientServ;

    @Override
    public void init() throws ServletException {

        ApplicationContext applicationContext =
                (ApplicationContext) getServletContext().getAttribute("spring-context");
        clientServ = applicationContext.getBean(ClientServ.class);
        super.init();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String driverLicenseNumber = req.getParameter("driverLicenseNumber");
        String pass = req.getParameter("pass");

        PrintWriter printWriter = resp.getWriter();
        Client client = clientServ.register(firstName, secondName,
                phoneNumber, email, driverLicenseNumber, secondName);
        req.setAttribute("client", client);
        LOGGER.info("successful registration" + client.toString());
        /*req.getRequestDispatcher("/register.jsp").
                forward(req, resp);*/
        req.getRequestDispatcher("/WEB-INF/pages/clientMenu.jsp").
                forward(req,resp);

        printWriter.flush();

    }
}
