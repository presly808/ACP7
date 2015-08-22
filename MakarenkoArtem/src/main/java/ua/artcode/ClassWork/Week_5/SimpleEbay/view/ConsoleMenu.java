package ua.artcode.ClassWork.Week_5.SimpleEbay.view;

import ua.artcode.ClassWork.Week_5.SimpleEbay.exception.ValidationException;
import ua.artcode.ClassWork.Week_5.SimpleEbay.exception.WrongUserCredentialException;
import ua.artcode.ClassWork.Week_5.SimpleEbay.model.Product;
import ua.artcode.ClassWork.Week_5.SimpleEbay.model.User;
import ua.artcode.ClassWork.Week_5.SimpleEbay.service.ProductService;
import ua.artcode.ClassWork.Week_5.SimpleEbay.service.UserService;

import java.util.List;
import java.util.Scanner;

/**
 * Created by serhii on 15.08.15.
 */
public class ConsoleMenu {

    private UserService userService;
    private ProductService productService;
    private Scanner input = new Scanner(System.in);
    private String sessionToken;

    public ConsoleMenu(UserService userService, ProductService productService) {
        this.productService = productService;
        this.userService = userService;
    }


    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void showMainMenu() {
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Add product");
        System.out.println("4.All products");
        System.out.println("5.Show MyProducts");
        System.out.println("6.Logout");
        System.out.println("7.Exit");
    }

    public void start() {
        int choice = 0;

        while (true) {
            showMainMenu();
            choice = input.nextInt();
            dispatchChoice(choice);

        }

    }

    private void dispatchChoice(int choice) {
        switch (choice) {

            case 1: {
                showLoginMenu();
                break;
            }

            case 2: {
                showRegisterMenu();
                break;
            }

            case 3: {
                showAddProductMenu();
                break;
            }

            case 4: {
                showAllProductsMenu();
                break;
            }

        }
    }

    private void showAllProductsMenu() {
        List<Product> productList = productService.getAll();
        for (Product product : productList) {
            System.out.println("\t" + product);
        }

    }

    private void showAddProductMenu() {
        if (sessionToken == null) {
            System.out.println("Please login first!!!");
            return;
        }
        System.out.println("Input title");
        String title = input.next();
        System.out.println("Input description");
        String desc = input.next();
        System.out.println("Input price");
        double price = input.nextDouble();
        productService.addNewProduct(sessionToken, title,desc,price);

        System.out.println("Product added!!");

    }

    private void showRegisterMenu() {
        System.out.println("Input fullname");
        String fullname = input.next();
        System.out.println("Input phone");
        String phone = input.next();
        System.out.println("Input Email");
        String email = input.next();
        System.out.println("Input pass");
        String pass = input.next();

        try {
            User user = userService.register(fullname, phone, email, pass);
            System.out.println(user);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
            System.out.println("Try Again");
        }

    }

    private void showLoginMenu() {
        System.out.println("Input Email");
        String email = input.next();
        System.out.println("Input pass");
        String pass = input.next();

        try {
            sessionToken = userService.login(email, pass);
            System.out.println("You are in the system!");
        } catch (WrongUserCredentialException e) {
            System.err.println(e.getMessage());
            System.out.println("Try Again");
        }


    }


}
