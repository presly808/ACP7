package view;

import dao.ClientDao;
import dao.ClientDaoJPAImpl;
import exeption.NoClientFoundException;
import exeption.WrongUserCredentionalException;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ClientServ;
import sun.security.validator.ValidatorException;
import validation.MyValidationException;

import javax.xml.bind.ValidationException;
import java.util.Scanner;

/**
 * Created by root on 05.09.15.
 */

@Component //make a bean
public class ConsoleMenu {

    @Autowired //spring make injection
    private ClientServ clientServ;

    private Scanner scanner = new Scanner(System.in);
    private String sessionToken;
    private ClientDaoJPAImpl clientDao;


    public ConsoleMenu() {
    }

    public void showMainMenu() {
        System.out.println("1. Sign-in");
        System.out.println("2. Sign-up");
        System.out.println("3. Show repair serv.");
        System.out.println("4. Show services");
        System.out.println("5. Store");
        System.out.println("6. Show Work-Day Dairy table");
        System.out.println("7. Exit");
    }

    public void start() {
        int choice = 0;

        while (true) {
            showMainMenu();
            choice = scanner.nextInt();
            dispatcherChois(choice);

        }
    }

    private void dispatcherChois(int choice) {

        if (choice != 0 && choice < 8) {
            if (choice == 1) {
                showSignInMenu();
                return;
            }

            if (choice == 2) {
                showSignUpMenu();
                return;
            }

            if (choice == 3) {
                showRepairServMenu();
                return;
            }

            if (choice == 4) {
                showServicesMenu();
                return;
            }

            if (choice == 5) {
                showStoreMenu();
                return;
            }

            if (choice == 6) {
                showDairyWorkDayMenu();
                return;
            }

            if (choice == 7) {
                return;
            }


        } else {
            System.out.println("wrong choice");
        }
    }

    private void showDairyWorkDayMenu() {

    }

    private void showStoreMenu() {


    }

    private void showServicesMenu() {//wash,diagnostic,

    }

    private void showRepairServMenu() {

    }

    private void showSignUpMenu() {//register system

        System.out.println("Input first name");
        String firstName = scanner.next();
        System.out.println("Input second name");
        String secondName = scanner.next();
        System.out.println("Input phone number");
        String phoneNumber = scanner.next();
        System.out.println("Input E-mail");
        String email = scanner.next();
        System.out.println("Input driverLicenseNumber");
        String driverLicenseNumber = scanner.next();
        System.out.println("Input password");
        String pass = scanner.next();


        /*Client client = new Client(firstName, secondName, phoneNumber,
                email, driverLicenseNumber, pass);*/

        Client client = clientServ.register(firstName,secondName,phoneNumber,
                email,driverLicenseNumber,pass);



        //TODO validation for righ data in creating client;


    }

    private void showSignInMenu() {//enter system

        System.out.println("Input E-mail");
        String email = scanner.next();
        System.out.println("Input password");
        String pass = scanner.next();
        System.out.println("Input driverLicenseNumber");
        String driverLicenseNumber = scanner.next();


       /* try {
            sessionToken = clientServ.login(email, pass, driverLicenseNumber);
            System.out.println("You are in the system!");

        } catch (WrongUserCredentionalException e) {
            System.err.println(e.getMessage());
            System.out.println("Try Again");
        }*/


        try {
            if(email.equals( clientDao.findByEmail(email).getEmail())&&
                    pass.equals(clientDao.findByEmail(email).getPass()))

             sessionToken = clientServ.login(email, pass, driverLicenseNumber);
        } catch (NoClientFoundException e) {
            System.err.println(e.getMessage());
            System.out.println("Try Again");
            e.printStackTrace();
        }
        System.out.println("You are in the system!");


    }


}
