package Consol;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Legion on 05.07.2015.
 */
public class MyConsol {
    public static String fileOfHpelp = "C://Users//Legion//IdeaProjects//ACP7//OlesBovsunivsky//src//Consol//File_Hellp";
    public String comandWay = "C://";
    File bufferFile;

    public String readConsol() throws FileNotFoundException {

        System.out.println("Current directory " + comandWay);

        String[] s1 = new Scanner(System.in).nextLine().split(" ");

        if (s1[0].toLowerCase().equals("help")) System.out.println(MyFileClass.read(fileOfHelp)); //checking global command "Help"

        if (s1[0].toLowerCase().equals("exit")) return "exit";

        if (s1[0].toLowerCase().equals("mkdir")) mkDir();

        if (s1[0].toLowerCase().equals("rd")) delFolder();

        if (s1[0].toLowerCase().equals("cf")) creatFile();

        if (s1[0].toLowerCase().equals("dir")) dir();

        if (s1[0].toLowerCase().equals("copy")) copy();

        if (s1[0].toLowerCase().equals("find")) find(s1[1]);

        if (s1[0].toLowerCase().equals("cd")) {
            if (s1.length == 1) {
                System.out.println("Current directory -> " + comandWay);
            } else {
                cd(s1[1]);
                System.out.println("Current directory -> " + comandWay);
            }
        }
        return s1.toString();
    }

    /**
     * cd command - do they wot you wot
     */
    private String cd(String massCom) {
        comandWay = "";
        String[] sm = massCom.split("/");
        for (int i = 0; i < sm.length; i++) {
            comandWay = comandWay + sm[i] + "/";
        }
        return comandWay;
    }

    private void copy() {
        System.out.print("Write name of the file fo copy -> ");
        String nameFile = new Scanner(System.in).nextLine();
        System.out.print("Write extension of new file -> ");
        String extensionFile = new Scanner(System.in).nextLine();

        //    try{
        //       boolean created = newFile.createNewFile();
        //        if (created) System.out.println("File create");
        //   }
        //  catch (IOException e) {
        //      e.printStackTrace();
        //   }
        // }

    }
    private void dir() {
        File file = new File(comandWay);
        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + " \tcatalog");
                } else {
                    System.out.println(item.getName() + "\tfile");
                }
            }
        }
    }

    private void mkDir() {
        System.out.print("Write name of folder -> ");
        String s2 = new Scanner(System.in).nextLine();
        System.out.print("Write way of folder -> ");
        String s3 = new Scanner(System.in).nextLine();
        File file = new File(cd(s3) + s2);
        boolean create = file.mkdir();
        if (create) System.out.println("Folder with name " + s2 + " create");
    }

    private void delFolder() {
        System.out.print("Name of file for delete");
        String s3 = new Scanner(System.in).nextLine();
        File file = new File(s3);
        if (!file.exists()) return;
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                delFolder();
                file.delete();
            }
        } else {
            file.delete();
        }
    }

    private void creatFile() {
        System.out.print("Write name of new file -> ");
        String nameNewFile = new Scanner(System.in).nextLine();
        System.out.print("Write extension of new file -> ");
        String extensionNewFile = new Scanner(System.in).nextLine();
        //   File newFileFor = new File(comandWay+nameNewFile+"."+extensionNewFile);
        //  if(newFileFor.exists()){
        //      System.out.println("File with name "+nameNewFile+" exists");
        //       double nF = Math.random();
        //       nameNewFile=nameNewFile+"["+nF+"]";
        //   }
        File newFile = new File(comandWay + nameNewFile + "." + extensionNewFile);
        try {
            boolean created = newFile.createNewFile();
            if (created) System.out.println("File create");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void find(String nameOfFindFile) {
     //   File file = new File(comandWay);
    }
}



