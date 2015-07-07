import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Пользователь on 06.07.2015.
 */
public class FileHelperTest {
    public static void main(String[] args) throws IOException {
        boolean exit = false;//переменная условия выхода
        FileHelper fh = new FileHelper();
        File ourFile = new File("C:/");//задаем начальную папку
        fh.menu();
        outer: while (exit!=true) {
            System.out.println("Waiting for the command");
            Scanner sc = new Scanner(System.in);
            String com = sc.nextLine();
            String[] command = com.split(" ");
            if (command[0].equals("cd")) {
                ourFile=new File(command[1]);
                System.out.println("Current path="+ourFile.getCanonicalPath());
                continue outer;
                }
            if (command[0].equals("help")) {
                fh.menu();
            }

            if (command[0].equals("dir")) {
                fh.dir(ourFile);

            }

            if (command[0].equals("type")) {
                System.out.println(command[1].substring(command[1].lastIndexOf(".")));
                }

            if (command[0].equals("exit")) {
                exit=true;
            }
        }


    }
    }

