package ConsoleCommander.view;

import ConsoleCommander.controller.FileHelper;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Пользователь on 06.07.15.
 */
public class ClientView {

    private FileHelper fileHelper;


    public static final String CURRENT_LOCATION = "C:\\Program Files\\";

    public ClientView() {
        init();

        scannerReadCommand();


    }

    private void init() {

        System.out.print(CURRENT_LOCATION + ">");
    }

    private void scannerReadCommand() {

        Scanner sc = new Scanner(System.in);

        String result = sc.nextLine();
        FileHelper fileHelper = new FileHelper();

        String resultTrimm = result.trim();
        String resultLowerCase = resultTrimm.toLowerCase();

        /*String[] spliedString = resultLowerCase.split(">");*/

        if (resultLowerCase.startsWith("help") == true) {

            fileHelper.help();

        }

        if (resultLowerCase.startsWith("cd") == true) {
            String[] parts = resultTrimm.split("_");
            String pathNewLocation = parts[1];

            fileHelper.cd(pathNewLocation);

        }

        if (resultLowerCase.startsWith("find") == true) {
            String[] parts = resultTrimm.split("_");
            String fileName = parts[1];

            fileHelper.find(fileName, new File(CURRENT_LOCATION));

        }

        if (resultLowerCase.startsWith("dir") == true) {
            String[] parts = resultTrimm.split("_");
            String filePath = parts[1];
            fileHelper.dir(filePath);
        }

        if (resultLowerCase.startsWith("type")==true){
            String[] parts = resultTrimm.split("_");
            String filePath = parts[1];
            fileHelper.type(filePath);

        }


    }


}
