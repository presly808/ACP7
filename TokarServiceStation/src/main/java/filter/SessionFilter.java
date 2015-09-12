package filter;

import model.Client;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.ClientServ;
import service.ClientServImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 09.09.15.
 */
public class SessionFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(SessionFilter.class);
    private ClientServImpl clientService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        ApplicationContext applicationContext =
                (ApplicationContext) filterConfig.getServletContext().getAttribute("spring-context");
        clientService = applicationContext.getBean(ClientServImpl.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookie = request.getCookies();
        for (Cookie cookie1 : cookie) {
            if (cookie1.getName().equals("accessToken")) {
                String value = cookie1.getValue();
                Client client = clientService.getClient(value);

                request.setAttribute("clientSessionToken", value);

                if (client == null) {
                    LOGGER.info("Authentification failled");
                   /* resp.sendRedirect("auth-error.html");*/
                }
            }
        }

        filterChain.doFilter(request, response);


    }

    @Override
    public void destroy() {

    }
}
