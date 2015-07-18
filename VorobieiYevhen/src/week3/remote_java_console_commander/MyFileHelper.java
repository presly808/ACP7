package week3.remote_java_console_commander;

import utils.IOUtils;
import week2.concole.FileHelper;

import java.io.*;


public class MyFileHelper implements FileHelper {
    private  String PATH = "C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\resources\\";
    File file;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public MyFileHelper(File file) {
        this.file = file;
    }

    @Override
    public String cd() {
        System.out.println("Enter directory:  ");


        String newPath = null;

        try {
            newPath =  br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File newConsolePath =  new File(search(new File(PATH),newPath));



        return newConsolePath != null ? newConsolePath.getAbsolutePath() : PATH;
    } //TODO

    @Override
    public void help() {

        readTxtFile("VorobieiYevhen\\resources\\Commands.txt");
    }

    @Override
    public void tree() {

        catalog(file);

    }

    private void readTxtFile(String path) {
        InputStream is = null;

        try {
            is = new FileInputStream(path);

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

        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {

                    System.out.println("\t<DIR>\t"  + item.getName());

                } else {
                    System.out.println("\t<FILE>\t"  + item.getName());
                }
            }
        }

    }

    @Override
    public boolean mkdir() {

        String folderName = getNewFolderName();

        if (notAllowedName(folderName)) return false;

        if (folderName == null || folderName.equals("")) {
            return  false;
        }
        if (search(file, folderName)!= null){
            System.out.println("Folder with current name already exist");
            return  false;
        }
            File newFile = new File(file.getAbsolutePath() + "\\" + folderName);
            newFile.mkdir();
            System.out.println("Directory " + newFile.getName() + " has been created.");
            return true;


    }

    private String getNewFolderName() {
        System.out.print("Write new directory name: ");
        String folderName = null;


        try {
            folderName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return folderName;
    }

    @Override
    public boolean mkfile() {

        String fileName = getNewFileName();

        if (notAllowedName(fileName)) return false;


        if (fileName == null || fileName.equals("")) {
            return  false;

        }
        fileName = setFileFormat(fileName);

        if (search(file, fileName) != null){
            System.out.println("File with current name already exist");
            return  false;
        }
        return createFile(fileName);


    }

    private boolean createFile(String fileName) {
        File newFile = new File(file.getAbsolutePath() + "\\" + fileName);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File " + newFile.getName() + " has been created.");
        return true;
    }

    private String setFileFormat(String fileName) {
        System.out.print("Write new file format: ");
        String fileFormat = null;


        try {
            fileFormat = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileName += "." + fileFormat;
        return fileName;
    }

    private String getNewFileName() {
        System.out.print("Write new file name: ");

        String fileName = null;


        try {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    private boolean notAllowedName(String fileName) {
        String[] notAllowed = {"+", "=", "[", "]", ":", ";", "«", ".", "/", "?", "\\", "*", "<", ">", "|"};
        for (int i = 0; i < notAllowed.length; i++) {
            if (fileName.contains(notAllowed[i])) {
                System.out.println("Not allowed symbols in file name. File not created.");
                return true;
            }
        }
        return false;
    }

    @Override
    public String find() {
        System.out.print("Write file name: ");
        String filePath = null;

        try {
            filePath = search(file, br.readLine());
            if (filePath != null) {
                return filePath;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File not found");
        return filePath;
    }

    @Override
    public void type() {
        String filePath = find();
        if (filePath.endsWith(".txt")) {
            readTxtFile(filePath);
        } else {
            System.out.println("Can't read this file! (Unreadable format)");
        }


    }

    @Override
    public boolean del() {
        File remove = new File(find());
        System.out.println("Doy really want to delete this file? (y/n): ");

        try {
            if (br.readLine().equalsIgnoreCase("y")) {
                remove.delete();
                System.out.println("File deleted");
                return true;
            } else{
            return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private  String search (File file, String fileName) {

       if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory() && item.getName().equalsIgnoreCase(fileName)) {

                    System.out.println("Directory " + fileName + " location is:  " + item.getAbsolutePath());
                    search(item, fileName);// TODO deep search
                    return item.getAbsolutePath();
                } else if (item.isFile() && item.getName().equalsIgnoreCase(fileName)){

                    System.out.println("File " + fileName + " location is:  " + item.getAbsolutePath());
                    return  item.getAbsolutePath();

                } else {
                    search(item, fileName);
                }

            }
       }
        return null; //todo
    }

    private String findFile (){
        System.out.print("Write file name: ");
        String fileName = null;

        try {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchFile(file, fileName);
    }

    private static String searchFile (File file, String fileName) {

        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    searchFile(item, fileName);
                } if (item.isFile() && item.getName().toLowerCase().contains(fileName.toLowerCase())){
                    System.out.println("File " + fileName + " location is:  " + item.getAbsolutePath());
                    return  item.getAbsolutePath();
                }
            }
        }
        return null;
    }






}
