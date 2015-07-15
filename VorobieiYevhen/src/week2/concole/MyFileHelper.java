package week2.concole;

import utils.IOUtils;

import java.io.*;


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
            is = new FileInputStream("VorobieiYevhen\\resources\\Commands.txt");

            IOUtils.readFullyByBytes(is); //read bytes and covert them to char

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

        } /*else if (search(file, folderName)){ // TODO if folder exist
            return  false;
        }*/
            File newFile = new File(file.getAbsolutePath() + "\\" + folderName);
            newFile.mkdir();
            System.out.println("Directory " + newFile.getName() + " has been created.");
            return true;


    }

    @Override
    public boolean find() {
        System.out.print("Write file name: ");
        String fileName = null;

        try {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        search(file, fileName);

        return false;
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

    private static boolean search (File file, String fileName) {
        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory() && item.getName().toLowerCase().contains(fileName.toLowerCase())) {

                    System.out.println("Directory " + fileName + " location is:  " + item.getAbsolutePath());
                    return true; // TODO deep search

                } else if (item.isFile() && item.getName().toLowerCase().contains(fileName.toLowerCase())){
                        try {
                            System.out.println("File " + fileName + " location is:  " + item.getCanonicalPath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    return  true;

                } else {
                    search(item, fileName);
                }
            }
        }
        return false;
    }

}
