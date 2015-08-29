package view;


import exception.ValidationException;
import exception.WrongUserCredentialException;
import model.User;
import service.UserService;

import java.util.Scanner;

public class ConsoleMenu {
    private UserService userService;
    private Scanner input = new Scanner(System.in);
    private String sessionToken;

    public ConsoleMenu(UserService userService) {
        this.userService = userService;
    }

    public void showMainMenu() {
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Add patient");
        System.out.println("4.All patients");
        System.out.println("5.Show my patients");
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

           /* case 3: {
                showAddProductMenu();
                break;
            }

            case 4: {
                showAllProductsMenu();
                break;
            }*/

            default:
                System.out.println("Wrong enter!");

        }
    }
    private void showLoginMenu() {
        System.out.println("Input login");
        String login = input.next();
        System.out.println("Input pass");
        String pass = input.next();

        try {
            sessionToken = userService.login(login, pass);
            System.out.println("You are in the system!");
        } catch (WrongUserCredentialException e) {
            System.err.println(e.getMessage());
            System.out.println("Try Again");
        }


    }

    private void showRegisterMenu() {
        System.out.println("Input fullname");
        String fullname = input.next();
        System.out.println("Input rank");
        String rank = input.next();
        System.out.println("Input phone");
        String phone = input.next();
        System.out.println("Input Email");
        String email = input.next();
        System.out.println("Input login");
        String login = input.next();
        System.out.println("Input pass");
        String pass = input.next();

        try {
            User user = userService.register(fullname, rank, email, phone, login, pass);
            System.out.println(user);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
            System.out.println("Try Again");
        }

    }
}

