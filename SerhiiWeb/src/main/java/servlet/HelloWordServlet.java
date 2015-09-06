package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWordServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("SERVLET CREATED");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = String.format("method %s, remote %s, query %s", req.getMethod(),
                req.getRemoteAddr(),
                req.getQueryString());

        PrintWriter pw = resp.getWriter();
        pw.println("<div><h1>User INfo</h1>" +
                "Your info from server " + info +
                "<div>");

        pw.flush();

    }

    @Override
    public void destroy() {
        System.out.println("SERVLET DESTROYED");
    }
}
