package ua.artcode.ClassWork.Week_5.SimpleEbay;

import ua.artcode.ClassWork.Week_5.SimpleEbay.dao.UserDaoJDBCImp;
import ua.artcode.ClassWork.Week_5.SimpleEbay.model.Product;
import ua.artcode.ClassWork.Week_5.SimpleEbay.service.ProductService;
import ua.artcode.ClassWork.Week_5.SimpleEbay.service.UserService;
import ua.artcode.ClassWork.Week_5.SimpleEbay.service.UserServiceImpl;
import ua.artcode.ClassWork.Week_5.SimpleEbay.view.ConsoleMenu;


public class Run{


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(new UserDaoJDBCImp(), null);
        ProductService productService = null;

        ConsoleMenu consoleMenu = new ConsoleMenu(userService,productService);
        consoleMenu.start();
    }
}
