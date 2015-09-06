package view;


import exception.ValidationException;
import exception.WrongUserCredentialException;
import model.Doctor;
import service.DoctorService;
import org.apache.log4j.*;

import java.io.IOException;
import java.util.Scanner;



public class ConsoleMenu {
    private DoctorService doctorService;
    private Scanner input = new Scanner(System.in);
    private String sessionToken;

    public ConsoleMenu(DoctorService doctorService) throws IOException {
        this.doctorService = doctorService;

    }

    private Logger loggerWriter() {
        Logger logger = LogManager.getLogger(ConsoleMenu.class);

        logger.setLevel(Level.ALL);
        Layout layout = new TTCCLayout("ISO8601");
        Appender appenderConsole = new ConsoleAppender(layout);
        logger.addAppender(appenderConsole);
        try {
            logger.addAppender(new FileAppender(layout, "tmp/log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }



    public void showMainMenu() {
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Add patient");
        System.out.println("4.All patients");
        System.out.println("5.Show my patients");
        System.out.println("6.Edit patient");
        System.out.println("7.Logout");
        System.out.println("8.Exit");
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
            sessionToken = doctorService.login(login, pass);
            loggerWriter().info("Doctor " + login + " log in");
            System.out.println("You are in the system!");
        } catch (WrongUserCredentialException e) {
            System.err.println(e.getMessage());
            loggerWriter().error("Wrong User Credential enter, login - " + login + ", pass - " + pass);
            System.out.println("Try Again");
        }


    }

    private void showRegisterMenu() {
        System.out.println("Input fullName");
        String fullName = input.next();
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
            Doctor doctor = doctorService.register(fullName, rank, email, phone, login, pass);
            System.out.println(doctor);
            loggerWriter().info(doctor.getFullName() + " registered in system");
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
            System.out.println("Try Again");
            loggerWriter().error("ValidationException during registration: " +
                    "Doctor{" +
                    "fullName='" + fullName + '\'' +
                    ", rank='" + rank + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", login='" + login + '\'' +
                    '}');
        }

    }
}

