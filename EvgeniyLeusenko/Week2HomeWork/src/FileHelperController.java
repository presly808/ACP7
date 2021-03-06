import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by Пользователь on 06.07.2015.
 */
public class FileHelperController {
    public static void main(String[] args) throws IOException {
        FileHelperController fileHelperController=new FileHelperController();
        try {
            String com="help";
            fileHelperController.Main(com);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Main(String com) throws IOException {
        boolean exit = false;//переменная условия выхода
        FileHelper fh = new FileHelper();
        File ourFile = new File("C:/");//задаем начальную папку
        fh.menu();
        outer:
        while (exit != true) {
            System.out.println("Waiting for the command");
            Scanner sc = new Scanner(System.in);
            com = sc.nextLine();
            String[] command = com.split(" ");
            if (command[0].equals("cd")) {
                ourFile = new File(command[1]);
                System.out.println("Current path=" + ourFile.getCanonicalPath());
                continue outer;
            }
            if (command[0].equals("help")) {
                fh.menu();
            }

            if (command[0].equals("find")) {
                boolean result = fh.find(ourFile, command[1]);
                if (result) {
                    System.out.println("Path contains file");
                } else {
                    System.out.println("Path do not contains file");
                }
            }

            if (command[0].equals("dir")) {
                fh.dir(ourFile);

            }

            if (command[0].equals("type")) {
                System.out.println(command[1].substring(command[1].lastIndexOf(".")));
            }

            if (command[0].equals("delete")) {
                ourFile = new File(command[1]);
                ourFile.delete();
                System.out.println(ourFile.exists());
                if (ourFile.exists()) {
                    System.out.println("Error in name file");
                } else {
                    System.out.println("File deleted");
                }
            }

            if (command[0].equals("mkdirs")) {
                ourFile = new File(command[1]);
                ourFile.mkdirs();
            }

            if (command[0].equals("new")) {
                ourFile = new File(command[1]);
                if (!ourFile.exists()) {
                    ourFile.createNewFile();
                }
                if (ourFile.exists()) {
                    System.out.println("Error in name file");
                } else {
                    System.out.println("File created");
                }
            }

            if (command[0].equals("tree")) {
                fh.showTree(ourFile);

            }

            if (command[0].equals("copy")) {
                fh.copy(ourFile, new File("D:/"));
            }

            if (command[0].equals("content")) {
                ourFile = new File(command[1]);
                double[] arr = new double[4];//1-video,2-audio,3-txt,4-other
                String[] listFolder = ourFile.list();
                arr = fh.folderContent(listFolder);
                System.out.println("video=" + (arr[0] / (arr[0] + arr[1] + arr[2] + arr[3])) + "\n" +
                        "audio=" + (arr[1] / (arr[0] + arr[1] + arr[2] + arr[3])) + "\n" +
                        "txt=" + (arr[2] / (arr[0] + arr[1] + arr[2] + arr[3])) + "\n" +
                        "others=" + (arr[3] / (arr[0] + arr[1] + arr[2] + arr[3])));
            }

            if (command[0].equals("exit")) {
                exit = true;
            }

        }
    }
    public String MainForSocket(String com) throws IOException {//Переделал аналогичный метод из void в return String
        boolean exit = false;//переменная условия выхода
        FileHelper fh = new FileHelper();
        File ourFile = new File("C:/");//задаем начальную папку
        String result = null;
            String[] command = com.split(" ");
            if (command[0].equals("cd")) {
                ourFile=new File(command[1]);
                result= String.valueOf(new StringBuilder("Current path="+ourFile.getCanonicalPath()));
                System.out.println("Current path="+ourFile.getCanonicalPath());
                return result;
            }

            if (command[0].equals("find")) {
                boolean res=fh.find(ourFile,command[1]);
                if(res){
                    result="Path contains file";}
                else{
                    result=("Path do not contains file");
                }
                return result;
            }

            if (command[0].equals("dir")) {
                fh.dir(ourFile);

            }

            if (command[0].equals("type")) {
                result= String.valueOf(new StringBuilder(command[1].substring(command[1].lastIndexOf("."))));
                return result;
            }

            if (command[0].equals("delete")) {
                ourFile=new File(command[1]);
                ourFile.delete();
                System.out.println(ourFile.exists());
                if(ourFile.exists()){
                    result="Error in name file";
                }
                else {
                    result="File deleted";}
                return result;
            }

            if (command[0].equals("mkdirs")) {
                ourFile=new File(command[1]);
                ourFile.mkdirs();
            }

            if (command[0].equals("new")) {
                ourFile=new File(command[1]);
                if(!ourFile.exists()) {
                    ourFile.createNewFile();
                }
                if(ourFile.exists()){
                    result="Error in name file";
                }
                else {
                    result="File created";}
                return result;
            }

            if (command[0].equals("tree")) {
                fh.showTree(ourFile);

            }

            if (command[0].equals("copy")) {
                fh.copy(ourFile,new File("D:/"));
            }

            if (command[0].equals("content")) {
                ourFile=new File(command[1]);
                double [] arr=new double[4];//1-video,2-audio,3-txt,4-other
                String []listFolder=ourFile.list();
                arr=fh.folderContent(listFolder);
                System.out.println("video="+(arr[0]/(arr[0]+arr[1]+arr[2]+arr[3]))+"\n"+
                        "audio="+(arr[1]/(arr[0]+arr[1]+arr[2]+arr[3]))+"\n"+
                        "txt="+(arr[2]/(arr[0]+arr[1]+arr[2]+arr[3]))+"\n"+
                        "others="+(arr[3]/(arr[0]+arr[1]+arr[2]+arr[3])));
            }

            if (command[0].equals("exit")) {
                exit=true;
            }

        return result;



    }
    }

