package week2.concole;

import java.io.*;

/**
 * Created by Джек on 11.07.2015.
 */
public class MyFileHelper implements FileHelper {

    File file;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public MyFileHelper(File file) {
        this.file = file;
    }

    @Override
    public void help() {
       InputStream is = null;

        try {
            is = new FileInputStream("C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\resources\\Commands.txt");

            readFullyByBytes(is);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null)
                    is.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void dir() {

        catalog(file);
    }

    @Override
    public boolean mkdir() {
        System.out.print("Write new directory name: ");
        String folderName = null;


        try {
            folderName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] notAllowed = {"+", "=", "[", "]", ":", ";", "«", ".", "/", "?", "\\", "*", "<", ">", "|"};
        for (int i = 0; i < notAllowed.length; i++) {
            if (folderName.contains(notAllowed[i])) {
                System.out.println("Not allowed symbols in file name. File not created.");
                return false;
            }
        }

        if (folderName == null || folderName.equals("")) {
            folderName = "New Folder";

        } /*else if (file.getName().contentEquals(find)){ // TODO if folder exist
            return  false;
        }*/
            File newFile = new File(file.getAbsolutePath() + "\\" + folderName);
            newFile.mkdir();
            System.out.println("Directory " + newFile.getName() + " has been created.");
            return true;


    }

    private static void readFullyByBytes (InputStream is) throws IOException {
        int oneByte;
        while ((oneByte = is.read()) != -1) {
            System.out.print((char) oneByte);
        }
    }

    private static void catalog (File file) {
        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {

                    System.out.println("Directory:  "  + item.getAbsolutePath());

                    catalog(item);

                } else {
                    System.out.println("\t\t\t" + "File: " + item.getName());
                }
            }
        }

    }
}
