package ua.artcode;

import ua.artcode.dao.UserDaoJDBCImp;
import ua.artcode.model.Product;
import ua.artcode.service.ProductService;
import ua.artcode.service.UserService;
import ua.artcode.service.UserServiceImpl;
import ua.artcode.view.ConsoleMenu;

/**
 * Created by serhii on 15.08.15.
 */
public class Run{


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(new UserDaoJDBCImp(), null);
        ProductService productService = null;

        ConsoleMenu consoleMenu = new ConsoleMenu(userService,productService);
        consoleMenu.start();
    }
}
