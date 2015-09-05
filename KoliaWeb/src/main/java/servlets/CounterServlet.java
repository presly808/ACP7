package servlets;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by pikolo on 05.09.15.
 */
public class CounterServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        System.out.println("SERVLET CREATED");
    }



    @Override
    public void destroy() {
        System.out.println("SERVLET DESTROYED");
    }

}
