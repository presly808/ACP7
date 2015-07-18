package week3.remote_java_console_commander;

import week2.concole.MyFileHelper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Console {
    private static String PATH = "C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\resources\\";
    private String currentPath = PATH;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ServerSocket server;



    public Console(ServerSocket server) {

        this.server = server;
    }

    public Console() {


    }



    public void window() throws IOException {
        Socket client = server.accept();

        DataOutputStream pw = new DataOutputStream(client.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));


        while (true) {
            MyFileHelper fileHelper = new MyFileHelper(new File(currentPath));
            pw.writeUTF("\nEnter menu (\"help\") operation (Press \"Enter\" to exit).\n" + currentPath + " > ");
            pw.flush();

            String select = null;

                try {
                    select = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (select.isEmpty()) {
                    break;
                }


            switch (select.toLowerCase()) {
                case "cd":
                    String newPath = fileHelper.cd();
                    currentPath = newPath != null ? newPath : PATH;

                    break;
                case "help":
                    fileHelper.help();
                    break;
                case "dir":
                    fileHelper.dir();
                    break;
                case "tree":
                    fileHelper.tree();
                    break;
                case "mkdir":
                    fileHelper.mkdir();
                    break;
                case "mkfile":
                    fileHelper.mkfile();
                    break;
                case "del":
                    fileHelper.del();
                    break;
                case "find":
                    fileHelper.find();
                    break;
                case "type":
                    fileHelper.type();
                    break;
                default:
                    System.out.println("No such command. View \"Help menu\" - \"help\"");
                    break;

            }
        }
    }
}
    


