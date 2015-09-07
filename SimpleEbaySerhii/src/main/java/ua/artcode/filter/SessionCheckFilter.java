package ua.artcode.filter;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ua.artcode.model.User;
import ua.artcode.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SessionCheckFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(SessionCheckFilter.class);
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext app = (ApplicationContext) filterConfig.getServletContext().getAttribute("spring-context");
        userService = app.getBean(UserService.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("accessToken")){
                String val = cookie.getValue();
                User user = userService.getUser(val);

                req.setAttribute("userSessionToken", val);

                if(user == null){
                    LOG.info("Auth fail");
                    resp.sendRedirect("auth-error.html");
                }
            }
        }

        chain.doFilter(req,resp);

    }

    @Override
    public void destroy() {

    }
}
