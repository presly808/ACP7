package ua.artcode.servlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ua.artcode.model.Product;
import ua.artcode.service.ProductService;
import ua.artcode.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/add-product"})
public class AddProductController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AddProductController.class);
    public static final String ADD_PRODUCT_PATH = "/WEB-INF/pages/add-product.jsp";
    public static final String PRODUCT_INFO_PAGE = "/WEB-INF/pages/product-info.jsp";

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        ApplicationContext app = (ApplicationContext) getServletContext().getAttribute("spring-context");
        productService = app.getBean(ProductService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ADD_PRODUCT_PATH).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String desc = req.getParameter("description");
        Double price = Double.parseDouble(req.getParameter("price"));

        String token = (String) req.getAttribute("userSessionToken");

        Product product = productService.addNewProduct(token,title,desc,price);

        req.setAttribute("product", product);

        req.getRequestDispatcher(PRODUCT_INFO_PAGE).forward(req,resp);


    }
}
